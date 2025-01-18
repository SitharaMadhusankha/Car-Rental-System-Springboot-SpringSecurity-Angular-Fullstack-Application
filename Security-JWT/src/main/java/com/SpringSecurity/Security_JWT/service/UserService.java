package com.SpringSecurity.Security_JWT.service;

import com.SpringSecurity.Security_JWT.entity.Role;
import com.SpringSecurity.Security_JWT.entity.User;
import com.SpringSecurity.Security_JWT.repo.RoleRepository;
import com.SpringSecurity.Security_JWT.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepository roleRepository;


    public User registerNewUser(User user) {
        return userRepo.save(user);
    }

    public void initRoleAndUser(){
        Role adminRole = new Role();
        Role userRole = new Role();
        if(!roleRepository.existsById("Admin")) {

            adminRole.setRoleName("Admin");
            adminRole.setRoleDescription("Admin role");
            roleRepository.save(adminRole);
        }

        if(!roleRepository.existsById("User")) {

            userRole.setRoleName("user");
            userRole.setRoleDescription("user role");
            roleRepository.save(userRole);
        }
        User user = new User();
        if(!userRepo.existsById("user123")) {
            user.setUserName("user123");
            user.setUserPassword("user@123");
            user.setUserFirstName("sithara");
            user.setGetUserLastName("Madusankha");

            Set<Role> userRoles = new HashSet<>();
            userRoles.add(adminRole);

            user.setRole(userRoles);
            userRepo.save(user);
        }
    }
}
