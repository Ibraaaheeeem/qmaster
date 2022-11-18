package com.haneef.quranmaster.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeHttpRequests((authz) -> {
                try {
                    authz
                    .anyRequest().authenticated()
                    .and() 
                    .formLogin() .loginPage("/login")
                    .permitAll() 
                    .and() 
                    .logout() .invalidateHttpSession(true) 
                    .clearAuthentication(true) 
                    .permitAll();
                } catch (Exception e) {
                    
                    e.printStackTrace();
                }
            });

        return http.build();
    }
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/signin", "/signup", "/css/**", "/js/**", "/qfiles/**", "/img/**", "/");
    }

}