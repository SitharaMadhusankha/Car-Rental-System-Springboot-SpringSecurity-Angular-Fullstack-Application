package com.SpringSecurity.Security_JWT.controller;

import com.SpringSecurity.Security_JWT.entity.Role;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {


    @PostMapping({"/cfeate-new-role"})
    public Role createNewRole(@RequestBody Role role){
        return  roleService.createNewRole(role);
    }

}
