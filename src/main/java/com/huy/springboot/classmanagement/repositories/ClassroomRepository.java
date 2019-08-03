package com.huy.springboot.classmanagement.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.huy.springboot.classmanagement.models.Classroom;

@Repository(value = "classroomRepo")
public class ClassroomRepository {
    @Autowired
    @PersistenceContext
    private EntityManager entityManager;
    
    public void save(final Classroom classroom) {
        entityManager.merge(classroom);
    }

    public void update(final Classroom classroom) {
        Classroom classroom2 = entityManager.find(Classroom.class, classroom.getId());
        classroom2.setCourseId(classroom.getCourseId());
        classroom2.setKidId(classroom.getKidId());
        classroom2.setTeacherId(classroom.getTeacherId());
        classroom2.setTime(classroom.getTime());
        classroom2.setStatus(classroom.isStatus());
    }

    public Classroom findById(final int id) {
        return entityManager.find(Classroom.class, id);
    }
    
    public void delete(final Classroom classroom) {
        entityManager.remove(classroom);
    }

    public List<Classroom> findAll() {
        TypedQuery<Classroom> query = (TypedQuery<Classroom>) entityManager.createQuery("FROM Classroom", Classroom.class);
        List<Classroom> classrooms = query.getResultList();
        return classrooms;
    }
}
