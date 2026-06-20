package com.karthik.incidentmanagement.service;

import com.karthik.incidentmanagement.dto.LoginRequestDto;
import com.karthik.incidentmanagement.dto.LoginResponseDto;
import com.karthik.incidentmanagement.dto.RegisterRequestDto;
import com.karthik.incidentmanagement.entity.User;
import com.karthik.incidentmanagement.repository.UserRepository;
import com.karthik.incidentmanagement.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public String register(RegisterRequestDto dto) {

        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            return "Email already exists";
        }

        User user = User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(dto.getRole())
                .build();

        userRepository.save(user);

        return "User registered successfully";
    }

    @Override
    public LoginResponseDto login(LoginRequestDto dto) {

        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(
                dto.getPassword(),
                user.getPassword())) {

            throw new RuntimeException("Invalid credentials");
        }

        return new LoginResponseDto(
                jwtService.generateToken(user.getEmail())
        );
    }
}