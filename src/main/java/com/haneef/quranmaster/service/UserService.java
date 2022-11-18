package com.haneef.quranmaster.service;

import com.haneef.quranmaster.entity.User;
import com.haneef.quranmaster.web.UserRegistrationDto;

public interface UserService {
 User save(UserRegistrationDto newUserRegistrationDto);
 
}
