package com.SpringSecurity.Security_JWT.repo;

import com.SpringSecurity.Security_JWT.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface RoleRepository  extends JpaRepository<Role,String> {
    Role createNewRole(Role role);
}
