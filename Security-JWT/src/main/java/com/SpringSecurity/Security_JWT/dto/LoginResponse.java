package com.SpringSecurity.Security_JWT.dto;

import com.SpringSecurity.Security_JWT.entity.User;

public class LoginResponse {

    private User user;
    private String jwtToken;

    public LoginResponse(User user, String jwtToken) {
        this.user = user;
        this.jwtToken = jwtToken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
