package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
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
    private UserRepository usersDao;

    public PostController(PostRepository postsDao, UserRepository usersDao){

        this.postsDao = postsDao;
        this.usersDao = usersDao;

    }
    @GetMapping("/posts")
    public String posts(Model model){
        List<Post> posts = postsDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }
    @PostMapping("/posts")
    public String showupdated(Model model, @RequestParam String title, @RequestParam String body){
        Post post = new Post(title, body);
//        posts.add(newPost);
        User user = usersDao.findById(1); //for testing this out with the first user in the table;
        post.setUser(user);
        postsDao.save(post);

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