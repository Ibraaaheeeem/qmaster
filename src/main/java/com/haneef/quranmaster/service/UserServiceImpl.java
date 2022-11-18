package com.haneef.quranmaster.service;

import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.stereotype.Service;

import com.haneef.quranmaster.entity.User;
import com.haneef.quranmaster.repository.UserRepository;
import com.haneef.quranmaster.web.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService{

    public UserServiceImpl(UserRepository userRepository, HashService hashService) {
        this.userRepository = userRepository;
        this.hashService = hashService;
    }

    private UserRepository userRepository;
	private final HashService hashService;

    @Override
    public User save(UserRegistrationDto userRegistrationDto) {
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);
            String encodedSalt = Base64.getEncoder().encodeToString(salt);
            String hashedPassword = hashService.getHashedValue(userRegistrationDto.getPassword(), encodedSalt);
            
            User user = new User(
            userRegistrationDto.getUsername(),
            userRegistrationDto.getEmail(),
            encodedSalt,
            hashedPassword,
            false,
            true
            );
        return userRepository.save(user);
    }

    
}
