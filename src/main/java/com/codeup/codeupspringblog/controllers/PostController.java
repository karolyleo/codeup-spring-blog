package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
//    List<Post> posts = new ArrayList<>();
    private PostRepository postsDao;
    public PostController(PostRepository postsDao){
        this.postsDao = postsDao;
    }
    @GetMapping("/posts")
    public String posts(Model model){
        List<Post> posts = postsDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }
    @PostMapping("/posts")
    public String showupdated(Model model, @RequestParam String title, @RequestParam String body){
        Post newPost = new Post(title, body);
//        posts.add(newPost);
        postsDao.save(newPost);

//        model.addAttribute("posts", posts);
        return "redirect:/posts";
    }
    @GetMapping("/posts/{id}")
    public String viewId(@PathVariable Long id, Model model){
        Post post = postsDao.findById(id).get();
        model.addAttribute("post", post);
        return "posts/show";
    }
    @GetMapping("/posts/create")
    public String create(){
        return "posts/create";
    }
    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
//    @PostMapping("/posts/create")
    @ResponseBody
    public String addOne() {
        return "Creating new post...";
    }
}