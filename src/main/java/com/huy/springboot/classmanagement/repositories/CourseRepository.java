package com.huy.springboot.classmanagement.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.huy.springboot.classmanagement.models.Course;

@Repository(value = "courseRepo")
@Component
public class CourseRepository{
    @Autowired
    @PersistenceContext
    private EntityManager entityManager;
    
    public void save(final Course course) {
        entityManager.persist(course);
    }

    public void update(final Course course) {
        Course course2 = entityManager.find(Course.class, course.getId());
        course2.setDescription(course.getDescription());
        course2.setName(course.getName());
    }

    public Course findById(final int id) {
        return entityManager.find(Course.class, id);
    }
    
    public void delete(final Course course) {
        entityManager.remove(course);
    }

    public List<Course> findAll() {
        TypedQuery<Course> query = (TypedQuery<Course>) entityManager.createQuery("FROM Course", Course.class);
        List<Course> courses = query.getResultList();
        return courses;
    }
}
