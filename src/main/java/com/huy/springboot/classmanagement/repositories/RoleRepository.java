package com.huy.springboot.classmanagement.repositories;

import org.springframework.data.repository.CrudRepository;

import com.huy.springboot.classmanagement.domains.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

    Role findByName(String name);

}
