package com.example.pantrypal.controller;

import com.example.pantrypal.model.User;
import com.example.pantrypal.security.JwtUtil;
import com.example.pantrypal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        userService.registeredUser(user.getUsername(), user.getPassword());
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody User user) {
        User authenticatedUser = userService.authenticate(user.getUsername(), user.getPassword());
        String token = jwtUtil.generateToken(authenticatedUser.getUsername());

        Map<String, String> res = new HashMap<>();
        res.put("token", token);

        return ResponseEntity.ok(res);
    }
}
