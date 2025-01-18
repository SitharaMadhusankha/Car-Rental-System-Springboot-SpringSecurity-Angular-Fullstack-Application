package com.SpringSecurity.Security_JWT.service;

import com.SpringSecurity.Security_JWT.entity.Role;
import com.SpringSecurity.Security_JWT.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role createNewRole(Role role){
        return roleRepository.save(role);
    }

}
