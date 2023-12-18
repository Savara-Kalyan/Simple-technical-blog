package org.app.TechnicalBlog.controller;

import org.app.TechnicalBlog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class HomeController {
    @ResponseBody
    public String getAllPosts(Model model) {


        ArrayList<Post> posts = new ArrayList<>();

        Post post1 = new Post();
        post.setTitle("Post 1");
        post.setBody("Post Body 1");
        post.setDate(new Date());

        Post post2 = new Post();
        post2.setTitle("Post 2");
        post2.setBody("Post Body 2");
        post2.setDate(new Date());

        Post post3 = new Post();
        post3.setTitle("Post 3");
        post3.setBody("Post Body 3");
        post3.setDate(new Date());

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);


        modle.addAtribute("posts" , posts);
        return "index";

    }
}
