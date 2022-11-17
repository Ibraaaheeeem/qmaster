package com.haneef.quranmaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.haneef.quranmaster.entity.User;


@Controller
public class UserController {

    @GetMapping("signin")
    public String signinForm(Model model){
        User newUser = new User();
		model.addAttribute("user", newUser);
        return "signin";
    }

    @PostMapping("signout")
    public String signoutForm(Model model){
        User newUser = new User();
		model.addAttribute("user", newUser);
        return "signout";
    }

    @PostMapping("signin")
    public String signin(Model model){
        User newUser = new User();
		model.addAttribute("user", newUser);
        return "redirect:/";
    }
}
