package com.SpringSecurity.Security_JWT.repo;

import com.SpringSecurity.Security_JWT.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserRepo  extends JpaRepository<User,String> {
}
