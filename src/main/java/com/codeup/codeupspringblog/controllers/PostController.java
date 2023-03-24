package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String posts(){
        return "<h1>posts index page</h1>";
    }
    @GetMapping("/posts/{id}")
    @ResponseBody
    public String viewId(@PathVariable String id){
        return "<h1>You are viewing : " + id + "</h1>";
    }
    @GetMapping("/posts/create")
    @ResponseBody
    public String create(){
        return "<form method=\"POST\"><button type=\"submit\">Submit</button></form>";
    }
    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
//    @PostMapping("/posts/create")
    @ResponseBody
    public String addOne() {
        return "Creating new post...";
    }
}
//GET	/posts	posts index page
//GET	/posts/{id}	view an individual post
//GET	/posts/create	view the form for creating a post
//POST	/posts/create	create a new post