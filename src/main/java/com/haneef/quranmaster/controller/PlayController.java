package com.haneef.quranmaster.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlayController {

    @GetMapping("/")
    public String play(Model model){
        int[] randomIndices = new int[2 * 3];
        int limit = randomIndices.length;
        Random r = new Random();
        for(int i = 0; i < limit; i++){
            randomIndices[i] = r.nextInt(limit);
            for(int j= 0; j < i;  j++){
                if (randomIndices[i] == randomIndices[j]) {
                    randomIndices[j] = r.nextInt(limit);
                }    
            }
            
        }
        for(int i = 0; i < randomIndices.length; i++){
            System.out.println(randomIndices[i]);
        }
        model.addAttribute("rows", new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14});
        model.addAttribute("columns", new int[]{4, 3, 2, 1, 0});
        model.addAttribute("indices", randomIndices);
        model.addAttribute("difficulty", 5);
        return "play";
    }
    
}
