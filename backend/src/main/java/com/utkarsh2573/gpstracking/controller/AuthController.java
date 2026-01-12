package com.utkarsh2573.gpstracking.controller;

import com.utkarsh2573.gpstracking.dto.LoginRequest;
import com.utkarsh2573.gpstracking.entity.User;
import com.utkarsh2573.gpstracking.repository.UserRepository;
import com.utkarsh2573.gpstracking.security.JwtService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    private final UserRepository repo;
    private final JwtService jwt;

    public AuthController(UserRepository repo, JwtService jwt) {
        this.repo = repo;
        this.jwt = jwt;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest req) {
        User user = repo.findByEmail(req.email())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(req.password())) {
            throw new RuntimeException("Invalid credentials");
        }
        return jwt.generateToken(user.getEmail());
    }
}
