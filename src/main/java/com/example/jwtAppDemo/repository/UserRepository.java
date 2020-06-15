package com.example.jwtAppDemo.repository;

import com.example.jwtAppDemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);


}
