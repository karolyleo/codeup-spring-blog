package com.codeup.codeupspringblog.controllers;

import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
public class DiceController {
    @GetMapping("/roll-dice")
    public String roll(){
        return "roll";
    }
    @PostMapping("/roll-dice")
    public String roll(@RequestParam int guess){
        String redirect = "redirect:/roll-dice/" + guess;
        return redirect;
    }
    @GetMapping("/roll-dice/{guess}")
    public String add(@PathVariable int guess, Model model) {
        Random rand = new Random();
        int randomNum = rand.nextInt(6) + 1;
        String string = "";
        if ( guess == randomNum ){
            string += "Correct! ";
        } else {
            string += "Incorrect! ";
        }
         string += "You guessed the number: " + guess + "\nThe dice rolled a number: " + randomNum;
        model.addAttribute("text", string);
        return "guess";
    }
}
