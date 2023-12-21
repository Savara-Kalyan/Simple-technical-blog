package org.app.TechnicalBlog.controller;

import org.app.TechnicalBlog.model.Post;
import org.app.TechnicalBlog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class PostController {
    @Autowired
    private PostService postService;
    @RequestMapping("posts")
    public String getUserPosts(Model model) {
        ArrayList<Post> posts = postService.get1Post();
        model.addAttribute("posts" , posts);
        return "posts";
    }
    @RequestMapping("posts/create")
    public String create() {
        return "posts/create";
    }
    @RequestMapping(value = "posts/createPost" , method = RequestMethod.POST)
    public String createPost(Post post) {
        postService.createPost(post);
        return "redirect:/posts";
    }

}
