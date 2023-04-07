package com.prac.jwtbasedapi.rest;

import com.prac.jwtbasedapi.dto.AdminUserDto;
import com.prac.jwtbasedapi.model.User;
import com.prac.jwtbasedapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/admin")
public class AdminRestControllerV1 {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<AdminUserDto> getUserById(@PathVariable(name = "id") Long id) {

        User user = userService.findById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        AdminUserDto adminUserDto = AdminUserDto.fromAdminUser(user);
        return new ResponseEntity<>(adminUserDto, HttpStatus.OK);
    }
}
