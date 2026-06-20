package com.karthik.incidentmanagement.service;

import com.karthik.incidentmanagement.dto.LoginRequestDto;
import com.karthik.incidentmanagement.dto.LoginResponseDto;
import com.karthik.incidentmanagement.dto.RegisterRequestDto;

public interface AuthService {

    String register(RegisterRequestDto dto);
    LoginResponseDto login(LoginRequestDto dto);
}