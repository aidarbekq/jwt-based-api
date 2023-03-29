package com.prac.jwtbasedapi.repository;

import com.prac.jwtbasedapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
