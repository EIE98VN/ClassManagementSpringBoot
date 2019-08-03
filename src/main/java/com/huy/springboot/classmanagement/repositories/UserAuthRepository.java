package com.huy.springboot.classmanagement.repositories;

import org.springframework.data.repository.CrudRepository;

import com.huy.springboot.classmanagement.domains.UserAuth;

public interface UserAuthRepository extends CrudRepository<UserAuth, Integer> {

    UserAuth findByEmail(String email);

}
