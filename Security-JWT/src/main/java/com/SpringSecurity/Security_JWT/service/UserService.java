package com.SpringSecurity.Security_JWT.service;

import com.SpringSecurity.Security_JWT.entity.Role;
import com.SpringSecurity.Security_JWT.entity.User;
import com.SpringSecurity.Security_JWT.repo.RoleRepository;
import com.SpringSecurity.Security_JWT.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public User registerNewUser(User user) {
        return userRepo.save(user);
    }


 public void initRoleAndUser(){
        Role adminRole = new Role();
        Role userRole = new Role();
        if(!roleRepository.existsById("Admin")){
            adminRole.setRoleName("Admin");
            adminRole.setRoleDescription("Admin role");
            roleRepository.save(adminRole);
        }
        if(!roleRepository.existsById("User")){
            userRole.setRoleName("User");
            userRole.setRoleDescription("User Role");
            roleRepository.save(userRole);
        }
        if(!userRepo.existsById("admin123")){
            User user = new User();
            user.setUserName("admin123");
            user.setUserPassword(getEncodedPassword("admin@123"));
            user.setUserFirstName("Sithara");
            user.setUserLastName("Madusankha");

            Set<Role> adminRoles = new HashSet<>();
            adminRoles.add(adminRole);

            user.setRole(adminRoles);
            userRepo.save(user);
        }
        if(!userRepo.existsById("user123")){
            User user = new User();
            user.setUserName("user123");
            user.setUserPassword(getEncodedPassword("user@123"));
            user.setUserFirstName("Isuru");
            user.setUserLastName("Malintha");

            Set<Role> userRoles = new HashSet<>();
            userRoles.add(userRole);

            user.setRole(userRoles);
            userRepo.save(user);
        }
 }

    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }
}
