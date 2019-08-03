package com.huy.springboot.classmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.huy.springboot.classmanagement.models.Classroom;
import com.huy.springboot.classmanagement.services.ClassroomService;

@RestController
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @RequestMapping(value = "/classrooms", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<Classroom> getCourses() {
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
    public void addUser(@RequestBody Classroom classroom) {
        classroomService.save(classroom);
    }

    @RequestMapping(value = "/classroom", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void updateUser(@RequestBody Classroom classroom) {
        classroomService.update(classroom);
    }

    @RequestMapping(value = "/classroom/{id}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public boolean deleteCourse(@PathVariable("id") int id) {
        Classroom classroom = classroomService.findById(id);
        return classroomService.delete(classroom);
    }
}
