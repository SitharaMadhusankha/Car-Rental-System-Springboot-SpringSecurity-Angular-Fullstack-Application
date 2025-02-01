package com.SpringSecurity.Security_JWT.controller;

import com.SpringSecurity.Security_JWT.dto.LoginRequest;
import com.SpringSecurity.Security_JWT.dto.LoginResponse;
import com.SpringSecurity.Security_JWT.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authentication"})
    public LoginResponse createJwtTokenAndLigin(@RequestBody LoginRequest loginRequest) throws Exception{
        return jwtService.createJwtToken(loginRequest);
    }
}
