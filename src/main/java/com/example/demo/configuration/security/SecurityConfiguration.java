package com.example.demo.configuration.security;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilterAfter(new JwtTokenVerifier(),JwtAuthenticationFilter.class)
                .authorizeRequests()

                .antMatchers("/login")
                .permitAll()

                .antMatchers(HttpMethod.POST,"/api/cooperatives","/api/clients","/api/admin")
                .permitAll()

                .antMatchers("/api/categories","/api/regions")
                .hasAnyAuthority("ADMIN")

                .antMatchers("/api/produits","/api/matiere","/api/origines")
                .hasAnyAuthority("COOPERATIVE","ADMIN")

                .antMatchers("/api/commands","/api/lignes")
                .hasAnyAuthority("COOPERATIVE","CLIENT")

                .anyRequest()
                .authenticated();

    }
}
