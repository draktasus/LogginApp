package com.example.demo.Repository;


import com.example.demo.domain.User;
import org.springframework.data.repository.CrudRepository;

//veritanı iletişini sağlayacağımız interface
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}