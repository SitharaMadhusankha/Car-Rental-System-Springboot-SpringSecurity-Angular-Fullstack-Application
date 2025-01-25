package com.SpringSecurity.Security_JWT.controller;

import com.SpringSecurity.Security_JWT.DTO.LoginRequest;
import com.SpringSecurity.Security_JWT.DTO.LogingRespones;
import com.SpringSecurity.Security_JWT.service.JwtService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public LogingRespones createJwtTokenAndlogin(@RequestBody LoginRequest loginRequest) throws Exception{
        return jwtService.createJwtToken(loginRequest);
    }
}
