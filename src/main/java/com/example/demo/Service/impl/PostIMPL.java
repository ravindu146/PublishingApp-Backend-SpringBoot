package com.example.demo.Service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Post;
import com.example.demo.Repo.PostRepo;
import com.example.demo.Service.PostService;


@Service
public class PostIMPL implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Override
    public int savePost(Post post) {
        Post savedPost = postRepo.save(post);
        return savedPost.getPostId(); 
    }

    @Override
    public ArrayList<Post> getPostsByUserId(int userId){
        return postRepo.findByUserId(userId);
    }

    @Override
    public Optional<Post> getPostById(int postId) {
        return postRepo.findById(postId);
    }

    @Override
    public void updatePost(Post post) {
        postRepo.save(post);
    }  
}
