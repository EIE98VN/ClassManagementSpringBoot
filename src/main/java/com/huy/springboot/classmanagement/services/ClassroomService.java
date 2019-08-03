package com.huy.springboot.classmanagement.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huy.springboot.classmanagement.models.Classroom;
import com.huy.springboot.classmanagement.repositories.ClassroomRepository;

@Service
@Transactional
public class ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    public boolean save(final Classroom classroom) {
        List<Classroom> classrooms = classroomRepository.findAll();
        for (Classroom classroom2 : classrooms) {
            if (classroom2.getCourseId() == classroom.getCourseId() && classroom2.getKidId() == classroom.getKidId()
                    && classroom2.getTeacherId() == classroom.getTeacherId()
                    && classroom2.getTime() == classroom.getTime())
                return false;
        }
        classroomRepository.save(classroom);
        return true;
    }

    public boolean update(final Classroom classroom) {
        List<Classroom> classrooms = classroomRepository.findAll();
        for (Classroom classroom2 : classrooms) {
            if (classroom2.getCourseId() == classroom.getCourseId() && classroom2.getKidId() == classroom.getKidId()
                    && classroom2.getTeacherId() == classroom.getTeacherId()
                    && classroom2.getTime() == classroom.getTime())
                return false;
        }
        classroomRepository.update(classroom);
        return true;
    }

    public Classroom findById(final int id) {
        return classroomRepository.findById(id);
    }

    public boolean delete(final Classroom classroom) {
        if (classroom.isStatus())
            return false;
        classroomRepository.delete(classroom);
        return true;
    }

    public void deleteWithoutHesitation(final Classroom classroom) {
        classroomRepository.delete(classroom);
    }

    public List<Classroom> findAll() {
        return classroomRepository.findAll();
    }
}
