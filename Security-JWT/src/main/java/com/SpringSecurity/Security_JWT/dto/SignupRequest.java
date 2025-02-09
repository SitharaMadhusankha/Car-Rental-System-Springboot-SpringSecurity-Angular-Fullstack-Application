package com.SpringSecurity.Security_JWT.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignupRequest {
    private String username;
    private String userFirstName;
    private String UserLastName;
    private String userPassword;
    private String userRole;
}
