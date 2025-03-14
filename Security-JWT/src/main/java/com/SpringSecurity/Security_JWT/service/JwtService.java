package com.SpringSecurity.Security_JWT.service;

import com.SpringSecurity.Security_JWT.dto.LoginRequest;
import com.SpringSecurity.Security_JWT.dto.LoginResponse;
import com.SpringSecurity.Security_JWT.entity.Role;
import com.SpringSecurity.Security_JWT.entity.User;
import com.SpringSecurity.Security_JWT.repo.UserRepo;
import com.SpringSecurity.Security_JWT.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.reactive.JettyResourceFactory;
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
                throw new UsernameNotFoundException("user not found with username :"+username);
        }

    }

    private Set getAuthority(User user){
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        for(Role role: user.getRole()){
            authorities.add(new SimpleGrantedAuthority("ROLE"+role.getRoleName()));
        }
        return authorities;
    }
    public LoginResponse createJwtToken(LoginRequest loginRequest) throws Exception{
        String username = loginRequest.getUserName();
        String userPassword =loginRequest.getUserPassword();

        authenticate(username,userPassword);

        UserDetails userDetails =loadUserByUsername(username);
        String newGeneratedToken =jwtUtil.generateToken(userDetails);
        User user = userRepo.findById(username).get();

        LoginResponse loginResponse = new LoginResponse(
                user,
                newGeneratedToken
        );
        return loginResponse;
    }

    private void authenticate(String username, String userPassword) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,userPassword));
        }catch (BadCredentialsException e){
            throw new Exception("INVALID_CREDENTIALS",e);
        }
    }
}
