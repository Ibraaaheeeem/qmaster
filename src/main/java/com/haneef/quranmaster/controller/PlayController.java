package com.haneef.quranmaster.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.haneef.quranmaster.entity.FirstVerses;

@Controller
public class PlayController {

    /**
     * @param model
     * @return
     */
    
    @GetMapping("/")
    public String play(Model model){
        List<Integer> randomIndices = new ArrayList<Integer>();
        int difficulty = 2;
        int pageNumber = 4;
        String randomString = "";
        int limit = difficulty * 15;
       
        Random r = new Random();
        while (randomIndices.size() < limit){
            int randomIndex = r.nextInt(limit);
            if (!randomIndices.contains(randomIndex)){
                randomIndices.add(randomIndex);
                randomString += randomIndex+" ";
            }
        }
        
        String[] pageOpenings = new FirstVerses().pageOpenings;
        model.addAttribute("indices", randomIndices);
        model.addAttribute("working_indices", randomString);
        model.addAttribute("page_openings", pageOpenings);
        model.addAttribute("difficulty", difficulty);
        model.addAttribute("page_number", pageNumber);
        return "play";
    }
    
}
