package com.example.lab7gtics.repository;

import com.example.lab7gtics.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}