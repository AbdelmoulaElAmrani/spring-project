package com.codeup.myproject.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RolldiceController {
    @GetMapping("/roll-dice")
    public String posts(){
        return "roll-dice";
    }
    @GetMapping("/roll-dice/{num}")
    public String luckyNum(@PathVariable int num, Model model){
        int randNum = (int) Math.floor(Math.random()* 6)+1;
        model.addAttribute("randNum" , randNum);
        model.addAttribute("num" , num);
        return "roll-dice-n";
    }
}
