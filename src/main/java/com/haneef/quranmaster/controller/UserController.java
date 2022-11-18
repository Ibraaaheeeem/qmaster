package com.haneef.quranmaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.haneef.quranmaster.entity.User;
import com.haneef.quranmaster.service.UserService;
import com.haneef.quranmaster.web.UserRegistrationDto;


@Controller
public class UserController {

    private UserService userService;

    
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("signin")
    public String signinForm(Model model){
        UserRegistrationDto newUserRegistration = new UserRegistrationDto();
		model.addAttribute("user", newUserRegistration);
        return "signin";
    }

    @PostMapping("signout")
    public String signoutForm(Model model){
        User newUser = new User();
		model.addAttribute("user", newUser);
        return "signout";
    }

    @PostMapping("signup")
    public String signup(@ModelAttribute("user") UserRegistrationDto newUserRegistrationDto){
        userService.save(newUserRegistrationDto);
        return "redirect:/signin?success";
    }

}
