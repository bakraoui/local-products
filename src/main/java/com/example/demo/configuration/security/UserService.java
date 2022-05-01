package com.example.demo.configuration.security;

import com.example.demo.configuration.security.service.AppUserRepository;
import com.example.demo.entities.Admin;
import com.example.demo.entities.Client;
import com.example.demo.repositories.AdminRepository;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.CooperativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    PasswordEncoderConfig passwordEncoderConfig;
    @Autowired
    AppUserRepository appUserRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser appUser = appUserRepository.findByUsername(username);
        User user = null;
        if (appUser != null){

            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            for (AppRole role: appUser.getRoles()) {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            }

            user = new User(appUser.getUsername(),
                    passwordEncoderConfig.passwordEncoder().encode(appUser.getPassword()),
                    authorities);
        }

        else{
            throw new RuntimeException("Username or password Does not Valid");
        }
        return user;
    }
}
