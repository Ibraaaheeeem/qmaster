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

    // @PostMapping("signin")
    public String signin(@ModelAttribute("user") UserRegistrationDto newUserRegistrationDto){
        //UserRegistrationDto newUserRegistration = new UserRegistrationDto();
		//model.addAttribute("user", newUserRegistration);
        return "redirect:/";
    }

    @PostMapping("signout")
    public String signoutForm(Model model){
        User newUser = new User();
		model.addAttribute("user", newUser);
        return "signout";
    }

    @PostMapping("signup")
    public String signup(@ModelAttribute("user") UserRegistrationDto newUserRegistrationDto){
        System.out.println("Saving 1");
        userService.save(newUserRegistrationDto);
        System.out.println("Saving 2");
        return "redirect:/signin?success";
    }

}
