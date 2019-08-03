package com.huy.springboot.classmanagement.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.huy.springboot.classmanagement.models.Classroom;
import com.huy.springboot.classmanagement.models.KidClass;
import com.huy.springboot.classmanagement.services.ClassroomService;

@RestController
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private EntityManager entityManager;

    @RequestMapping(value = "/classrooms", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<Classroom> getClassrooms() {
        List<Classroom> list = classroomService.findAll();
        return list;
    }

    @RequestMapping(value = "/classroom/{id}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Classroom getClassroom(@PathVariable("id") int id) {
        return classroomService.findById(id);
    }

    @RequestMapping(value = "/classroom", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public boolean addClassroom(@RequestBody Classroom classroom) {
        return classroomService.save(classroom);
    }

    @RequestMapping(value = "/classroom", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public boolean updateClassroom(@RequestBody Classroom classroom) {
        return classroomService.update(classroom);
    }

    @RequestMapping(value = "/classroom/{id}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public boolean deleteClassroom(@PathVariable("id") int id) {
        Classroom classroom = classroomService.findById(id);
        return classroomService.delete(classroom);
    }

    @SuppressWarnings({ "unchecked" })
    @RequestMapping(value = "/classroom/kid/{id}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<KidClass> getKidClassroom(@PathVariable("id") int id) {
        ArrayList<KidClass> lists = new ArrayList<KidClass>();
        TypedQuery<String> query = (TypedQuery<String>) entityManager
                .createQuery("Select name from Course where id in (select courseId from Classroom where kidId= :id)");
        query.setParameter("id", id);
        List<String> courseName = query.getResultList();
        query = (TypedQuery<String>) entityManager
                .createQuery("Select name from User where id in (select teacherId from Classroom where kidId= :id)");
        query.setParameter("id", id);
        List<String> teacherName = query.getResultList();

        for (int i = 0; i < courseName.size(); i++) {
            KidClass kidClass = new KidClass(courseName.get(i), teacherName.get(i));
            lists.add(kidClass);
        }
        return lists;
    }

    @RequestMapping(value = "/classroom/minute/{minute}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<Classroom> getClassroomsBeforeTime(@PathVariable("minute") long minute) {
        LocalDateTime now = LocalDateTime.now();
        if(now.getHour()<12) {
            now = now.plusHours(12);
        }
        List<Classroom> lists = new ArrayList<Classroom>();
        List<Classroom> classrooms = classroomService.findAll();
        for (Classroom classroom : classrooms) {
            if (classroom.isStatus() || (!classroom.getTime().isBefore(now)
                    && !now.plusMinutes(minute).isBefore(classroom.getTime()))) {
                lists.add(classroom);
            }
        }
        return lists;
    }
}
