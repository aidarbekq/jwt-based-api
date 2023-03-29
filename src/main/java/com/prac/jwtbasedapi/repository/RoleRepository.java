package com.prac.jwtbasedapi.repository;

import com.prac.jwtbasedapi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
