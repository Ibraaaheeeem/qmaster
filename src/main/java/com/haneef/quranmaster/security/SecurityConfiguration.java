package com.haneef.quranmaster.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.haneef.quranmaster.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserService userService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	// @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    //     http
    //         .csrf().disable()
    //         .authorizeHttpRequests((authz) -> {
    //             try {
    //                 authz
    //                 .anyRequest().authenticated()
    //                 .and() 
    //                 .formLogin()
    //                 .loginPage("/signin")
    //                 .defaultSuccessUrl("/play", true)
    //                 .permitAll() 
    //                 .and()
    //                 .logout() 
    //                 .invalidateHttpSession(true)
    //                 .clearAuthentication(true) 
    //                 .permitAll();
    //             } catch (Exception e) {
    //                 e.printStackTrace();
    //             }
    //         });

    //     return http.build();
    // }
    // @Bean
    // public WebSecurityCustomizer webSecurityCustomizer() {
    //     return (web) -> web.ignoring().antMatchers("/signin", "/signup", "/css/**", "/js/**", "/qfiles/**", "/img/**", "/");
    // }
	// @Override
	// protected void configure(AuthenticationManagerBuilder auth) throws Exception{
	// 	auth.authenticationProvider(authenticationProvider());
	// }
	
	
	 @Override
	 protected void configure(HttpSecurity http) throws Exception{
	 	http.authorizeRequests().antMatchers(
					
	 				"/signin**",
	 				"/signup",
	 				"/js/**",
	 				"/css/**",
	 				"/img/**").permitAll()
	 			.anyRequest().authenticated()
	 			.and()
	 			.formLogin()
	 			.loginPage("/signin")
	 			.permitAll()
	 			.and()
	 			.logout()
	 			.invalidateHttpSession(true)
	 			.clearAuthentication(true)
	 			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	 			.logoutSuccessUrl("/login?logout")
	 			.permitAll();
	}
	
}
