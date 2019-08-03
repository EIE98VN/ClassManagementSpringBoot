package com.huy.springboot.classmanagement.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huy.springboot.classmanagement.models.Classroom;
import com.huy.springboot.classmanagement.models.User;
import com.huy.springboot.classmanagement.repositories.ClassroomRepository;
import com.huy.springboot.classmanagement.repositories.UserRepository;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    public void save(final User user) {
        userRepository.save(user);
    }

    public void update(final User user) {
        userRepository.update(user);
    }

    public User findById(final int id) {
        return userRepository.findById(id);
    }

    public boolean delete(final User user) {
        List<Classroom> classrooms = classroomRepository.findAll();
        for (Classroom classroom : classrooms) {
            if ((classroom.getKidId() == user.getId() || classroom.getTeacherId() == user.getId())
                    && classroom.isStatus())
                return false;
        }
        userRepository.delete(user);
        return true;
    }

    public void deleteWithoutHesitation(final User user) {
        userRepository.delete(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
