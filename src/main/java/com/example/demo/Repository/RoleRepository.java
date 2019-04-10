package com.example.demo.Repository;

import  com.example.demo.domain.Role;
import org.springframework.data.repository.CrudRepository;

//veritanı iletişini sağlayacağımız interface
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String role);
}