package com.SpringSecurity.Security_JWT.service;

import com.SpringSecurity.Security_JWT.DTO.LoginRequest;
import com.SpringSecurity.Security_JWT.DTO.LogingRespones;
import com.SpringSecurity.Security_JWT.entity.Role;
import com.SpringSecurity.Security_JWT.entity.User;
import com.SpringSecurity.Security_JWT.repo.UserRepo;
import com.SpringSecurity.Security_JWT.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findById(username).get();

        if(user !=null){
            return new org.springframework.security.core.userdetails.User(
                    user.getUserName(),
                    user.getUserPassword(),
                    getAuthority(user)
            );
        }else{
            throw new UsernameNotFoundException("user not found with user Name :"+ username);
        }
    }

    private Set getAuthority(User user){
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        for (Role role: user.getRole()) {
            authorities.add(new SimpleGrantedAuthority("ROLE"+ role.getRoleName()));
        }
        return authorities;
    }

    public LogingRespones createJwtToken(LoginRequest loginRequest) throws Exception {
        String userName=loginRequest.getUserName();
        String userPassword=loginRequest.getUserPassword();

        authenticate(userName,userPassword);
        UserDetails userDetails =loadUserByUsername(userName);
        String newGeneratedToken =jwtUtil.generateToken(userDetails);
        User user =userRepo.findById(userName).get();

        LogingRespones logingRespones = new LogingRespones(
                user,
                newGeneratedToken
        );
        return logingRespones;
    }

    private void authenticate(String userName,String userPassword)throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,userPassword));
        }catch(BadCredentialsException e){
            throw new Exception("INVALID CREDENTIALS",e);
        }
    }
}
