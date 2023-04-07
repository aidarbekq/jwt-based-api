package com.prac.jwtbasedapi.security.jwt;

import com.prac.jwtbasedapi.model.Role;
import com.prac.jwtbasedapi.model.Status;
import com.prac.jwtbasedapi.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public final class JwtUserFactory {

    public JwtUserFactory () {}

    public static JwtUser create(User user) {
        log.info("user: {} , {}, {}", user.getUsername(), user.getRoles(), user.getId());
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getPassword(),
                user.getStatus().equals(Status.ACTIVE),
                mapToGrantedAuthorities(new ArrayList<>(user.getRoles()))
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
        return userRoles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
