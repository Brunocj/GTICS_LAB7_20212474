package com.example.lab7gtics.repository;

import com.example.lab7gtics.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByEmail(String email);

}
