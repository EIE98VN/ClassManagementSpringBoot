package com.huy.springboot.classmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.huy.springboot.classmanagement.services.ClassroomService;
import com.huy.springboot.classmanagement.services.CourseService;
import com.huy.springboot.classmanagement.services.UserService;

@RestController
public class MainController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private CourseService courseService;
    
    @Autowired
    private ClassroomService classroomService;
    
    
    
}
