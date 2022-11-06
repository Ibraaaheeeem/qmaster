package com.haneef.quranmaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlayController {

    @GetMapping("/")
    public String play(Model model){

        model.addAttribute("rows", new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14});
        model.addAttribute("columns", new int[]{4, 3, 2, 1, 0});
        model.addAttribute("difficulty", 5);
        return "play";
    }
    
}
