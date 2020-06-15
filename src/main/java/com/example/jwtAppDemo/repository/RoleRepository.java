package com.example.jwtAppDemo.repository;

import com.example.jwtAppDemo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
