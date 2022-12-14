package com.haneef.quranmaster.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.haneef.quranmaster.entity.Role;
import com.haneef.quranmaster.entity.User;
import com.haneef.quranmaster.repository.UserRepository;
import com.haneef.quranmaster.web.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        
    }

    private UserRepository userRepository;
	

    @Override
    public User save(UserRegistrationDto userRegistrationDto) {
            
            User user = new User(
            userRegistrationDto.getUsername(),
            userRegistrationDto.getEmail(),
            passwordEncoder.encode(userRegistrationDto.getPassword()),
            false,
            true,
            Arrays.asList(new Role("ROLE_USER"))
            );
        
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        User user = userRepository.findByEmail(email);
        
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password");
        }
        
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
   }
   private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
    return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
}
}
