package com.karthik.incidentmanagement.controller;

import com.karthik.incidentmanagement.dto.LoginRequestDto;
import com.karthik.incidentmanagement.dto.LoginResponseDto;
import com.karthik.incidentmanagement.dto.RegisterRequestDto;
import com.karthik.incidentmanagement.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String register(
            @Valid @RequestBody RegisterRequestDto dto) {

        return authService.register(dto);
    }

    @PostMapping("/login")
    public LoginResponseDto login(
            @Valid @RequestBody LoginRequestDto dto) {

        return authService.login(dto);
    }
}