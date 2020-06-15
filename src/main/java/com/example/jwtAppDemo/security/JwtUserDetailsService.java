package com.example.jwtAppDemo.security;

import ch.qos.logback.classic.Logger;
import com.example.jwtAppDemo.model.User;
import com.example.jwtAppDemo.security.jwt.JwtUser;
import com.example.jwtAppDemo.security.jwt.JwtUserFactory;
import com.example.jwtAppDemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;
    private Logger log;

    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        if(user == null) {
            throw new UsernameNotFoundException("User with username: + " + username + "not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("IN loadUserByUsername - user with username: {} successfully loaded", username);
        return jwtUser;
    }
}
