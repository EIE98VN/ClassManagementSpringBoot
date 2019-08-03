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

import com.huy.springboot.classmanagement.models.Course;
import com.huy.springboot.classmanagement.services.CourseService;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/courses", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<Course> getCourses() {
        List<Course> list = courseService.findAll();
        return list;
    }

    @RequestMapping(value = "/courses/{id}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Course getCourse(@PathVariable("id") int id) {
        return courseService.findById(id);
    }

    @RequestMapping(value = "/course", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public boolean addEmployee(@RequestBody Course course) {

        return courseService.save(course);
    }

    @RequestMapping(value = "/course", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public boolean updateCourse(@RequestBody Course course) {

        return courseService.update(course);
    }

    @RequestMapping(value = "/course/{id}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public boolean deleteCourse(@PathVariable("id") int id) {
        Course course = courseService.findById(id);
        return courseService.delete(course);
    }
}
