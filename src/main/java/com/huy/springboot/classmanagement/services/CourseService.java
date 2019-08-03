package com.huy.springboot.classmanagement.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huy.springboot.classmanagement.models.Classroom;
import com.huy.springboot.classmanagement.models.Course;
import com.huy.springboot.classmanagement.repositories.ClassroomRepository;
import com.huy.springboot.classmanagement.repositories.CourseRepository;

@Service
@Transactional
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    public boolean save(final Course course) {
        List<Course> courses = courseRepository.findAll();
        for (Course course2 : courses) {
            if (!(course.getId() == course2.getId()) && course2.getName().equals(course.getName()))
                return false;
        }
        courseRepository.save(course);
        return true;
    }

    public boolean update(final Course course) {
        List<Course> courses = courseRepository.findAll();
        for (Course course2 : courses) {
            if (!(course.getId() == course2.getId()) && course2.getName().equals(course.getName()))
                return false;
        }
        courseRepository.update(course);
        return true;
    }

    public Course findById(final int id) {
        return courseRepository.findById(id);
    }

    public boolean delete(final Course course) {
        List<Classroom> classrooms = classroomRepository.findAll();
        for (Classroom classroom : classrooms) {
            if (classroom.getCourseId() == course.getId() && classroom.isStatus())
                return false;
        }
        for (Classroom classroom : classrooms) {
            if(classroom.getCourseId()==course.getId()) {
                classroomRepository.delete(classroom);
            }                
        }
        courseRepository.delete(course);
        return true;
    }
    
    public void deleteWithoutHesitation(final Course course) {
        List<Classroom> classrooms = classroomRepository.findAll();
        for (Classroom classroom : classrooms) {
            if(classroom.getCourseId()==course.getId()) {
                classroomRepository.delete(classroom);
            }                
        }
        courseRepository.delete(course);
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }
}
