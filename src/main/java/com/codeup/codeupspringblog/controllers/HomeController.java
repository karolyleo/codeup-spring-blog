package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @GetMapping("/")
    @ResponseBody
    public String returnExercise(){
        return "This is the landing page!";
    }
    @GetMapping("/products/create")
    public String products(){
        return "product";
    }
    @PostMapping("/products/create")
    public String products(@RequestParam String name, @RequestParam int price){
        System.out.printf("Name is: %s%nPrice is: %d", name, price);
        return "redirect:/";
    }
}
