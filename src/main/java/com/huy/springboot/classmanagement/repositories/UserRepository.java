package com.huy.springboot.classmanagement.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.huy.springboot.classmanagement.models.User;

@Repository(value = "userRepo")
public class UserRepository {
    
    @Autowired
    @PersistenceContext
    private EntityManager entityManager;
    
    public void save(final User user) {
        entityManager.persist(user);
    }

    public void update(final User user) {
        User user2 = entityManager.find(User.class, user.getId());
        user2.setName(user.getName());
        user2.setRole(user.getRole());
    }

    public User findById(final int id) {
        return entityManager.find(User.class, id);
    }
    
    public void delete(final User user) {
        entityManager.remove(user);
    }

    public List<User> findAll() {
        TypedQuery<User> query = (TypedQuery<User>) entityManager.createQuery("FROM User", User.class);
        List<User> users = query.getResultList();
        return users;
    }
}
