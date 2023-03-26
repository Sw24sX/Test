package com.example.example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserDetailsService userDetailsService;

    @GetMapping("user")
    public UserDetails login(Principal principal) {
        return userDetailsService.loadUserByUsername(principal.getName());
    }

    @PostMapping("logout")
    public void logout() {
        // NOOP
    }
}
