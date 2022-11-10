package com.haneef.quranmaster.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlayController {

    /**
     * @param model
     * @return
     */
    @GetMapping("/")
    public String play(Model model){
        List<Integer> randomIndices = new ArrayList<Integer>();
        int limit = 5 * 15;
        Random r = new Random();
        while (randomIndices.size() < limit){
            int randomIndex = r.nextInt(limit);
            if (!randomIndices.contains(randomIndex)){
                randomIndices.add(randomIndex);
            }
        }
        for(int i = 0; i < randomIndices.size(); i++){
            System.out.print(randomIndices.get(i)+" - ");
        }
        model.addAttribute("rows", new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14});
        model.addAttribute("columns", new int[]{4, 3, 2, 1, 0});
        model.addAttribute("indices", randomIndices);
        model.addAttribute("difficulty", 5);
        return "play";
    }
    
}
