package com.localproducts.security;

import com.localproducts.security.service.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

        Optional<AppUser> appUser = appUserRepository.findByUsername(username);
        User user = null;
        if (appUser.isPresent()){

            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            for (AppRole role: appUser.get().getRoles()) {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            }

            user = new User(appUser.get().getUsername(),
                    passwordEncoderConfig.passwordEncoder().encode(appUser.get().getPassword()),
                    authorities);
        }

        else{
            throw new RuntimeException("Username or password Does not Valid");
        }
        return user;
    }
}
