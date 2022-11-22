package com.haneef.quranmaster.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.haneef.quranmaster.entity.User;
import com.haneef.quranmaster.web.UserRegistrationDto;

public interface UserService extends UserDetailsService{

 User save(UserRegistrationDto newUserRegistrationDto);

}