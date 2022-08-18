package com.example.parkingmysql.controller;

import com.example.parkingmysql.models.Post;
import com.example.parkingmysql.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    //get all posts
    @GetMapping("/posts")
    public String getPosts(Model model)
    {
        model.addAttribute("posts",postService.getPosts());
        return "posts";
    }

    //create a new post
    @GetMapping("/posts/new")
    public String createPost(Model model)
    {
        Post post = new Post();
        model.addAttribute("post",post);
        return "create_post";
    }

    //save post and go to posts page (handler method)
    @PostMapping("/posts")
    public String savePost(@ModelAttribute("post") Post post)
    {
        postService.savePost(post);
        return "redirect:/posts";
    }

    //update post
    @GetMapping("/posts/edit/{id}")
    public String updatePost(@PathVariable Long id, Model model)
    {
        model.addAttribute("post",postService.getPost(id));
        return "update_post";
    }

    //handler method
    @PostMapping("/posts/{id}")
    public String updatePost(@PathVariable Long id,
            @ModelAttribute("post") Post post,
            Model model)
    {
        //get posts from database
        Post existingPost = postService.getPost(id);
        existingPost.setId(id);
        existingPost.setFirstName(post.getFirstName());
        existingPost.setLastName(post.getLastName());
        existingPost.setDepartment(post.getDepartment());
        existingPost.setStart(post.getStart());
        existingPost.setEnd(post.getEnd());

        //save update
        postService.updatePost(existingPost);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}")
    public String deletePost(@PathVariable Long id)
    {
        postService.deletePost(id);
        return "redirect:/posts";
    }
}
