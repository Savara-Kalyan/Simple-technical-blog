package org.app.TechnicalBlog.service;

import org.app.TechnicalBlog.model.Post;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
@Service
public class PostService {

    public ArrayList<Post> getAllPosts() {

        ArrayList<Post> posts = new ArrayList<>();

//        Post post1 = new Post();
//        post1.setTitle("Post 1");
//        post1.setBody("Post Body 1");
//        post1.setDate(new Date());
//
//        Post post2 = new Post();
//        post2.setTitle("Post 2");
//        post2.setBody("Post Body 2");
//        post2.setDate(new Date());
//
//        Post post3 = new Post();
//        post3.setTitle("Post 3");
//        post3.setBody("Post Body 3");
//        post3.setDate(new Date());
//
//        posts.add(post1);
//        posts.add(post2);
//        posts.add(post3);

        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");

            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SimpleBlog" , "postgres" , "Pavan.k76");
                Statement statement = connection.createStatement();

                ResultSet rs = statement.executeQuery("SELECT * FROM post");

                while (rs.next()){
                    Post post = new Post();
                    post.setTitle(rs.getString("title"));
                    post.setBody(rs.getString("body"));

                    posts.add(post);
                }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }



        return posts;
    }

    public ArrayList<Post> get1Post() {
        ArrayList<Post> posts = new ArrayList<>();

//        Post post = new Post();
//        post.setTitle("New post for User");
//        post.setBody("New post for User");
//        post.setDate(new Date());
//        posts.add(post);

        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");

            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SimpleBlog" , "postgres" , "Pavan.k76");
                Statement statement = connection.createStatement();

                ResultSet rs = statement.executeQuery("SELECT * FROM post WHERE id = 3");

                while (rs.next()){
                    Post post = new Post();
                    post.setTitle(rs.getString("title"));
                    post.setBody(rs.getString("body"));

                    posts.add(post);
                }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return posts;
    }

    public void createPost(Post post){

    }
}
