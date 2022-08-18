package com.example.parkingmysql.services;

import com.example.parkingmysql.models.Post;
import com.example.parkingmysql.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    public Post savePost(Post post)
    {
        return postRepository.save(post);

    }

    public List<Post> getPosts()
    {
        return postRepository.findAll();
    }


    public Post getPost(Long id)
    {
        return postRepository.getById(id);
    }

    public Post updatePost(Post post)
    {
        return postRepository.save(post);
    }

    public void deletePost(@PathVariable Long id)
    {
        postRepository.deleteById(id);
    }

//
//    public String deletePost(@PathVariable Long id) {
//        postRepository.findById(id);
//        return "book deleted with id : " + id;
//    }
}
