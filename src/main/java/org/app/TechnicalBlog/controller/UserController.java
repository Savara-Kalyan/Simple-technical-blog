package org.app.TechnicalBlog.controller;

import org.app.TechnicalBlog.model.Post;
import org.app.TechnicalBlog.model.User;
import org.app.TechnicalBlog.service.PostService;
import org.app.TechnicalBlog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class UserController {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @RequestMapping("users/login")
    public String login() {
        return "users/login";
    }
    @RequestMapping("users/registration")
    public String registration() {
        return "users/registration";
    }
    @RequestMapping(value = "users/login" , method = RequestMethod.POST)
    public String loginUser(User user) {
        if (!userService.login(user)){
            return "users/login";
        }
        return "redirect:/posts";
    }
    @RequestMapping(value = "users/logout" , method = RequestMethod.POST)
    public String logout(Model model) {
        ArrayList<Post> posts = postService.getAllPosts();
        model.addAttribute("posts" , posts);
        return "redirect:/";
    }
    @RequestMapping(value = "users/registration" , method = RequestMethod.POST)
    public String registerUser(User user) {
        return "users/login";
    }
}
