package com.prac.jwtbasedapi.security;

import com.prac.jwtbasedapi.model.User;
import com.prac.jwtbasedapi.security.jwt.JwtUser;
import com.prac.jwtbasedapi.security.jwt.JwtUserFactory;
import com.prac.jwtbasedapi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("user loaded: {}, {}", user.getUsername(), user.getId());
        log.info("jwt user: {}, {}", jwtUser.getAuthorities(), jwtUser.getUsername());
        return jwtUser;
    }
}
