package com.example.demo.Service;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.Entity.Post;

public interface PostService {

    public int savePost(Post post);
    // Optional<Post> getPostByUserId(int postId);
    // Optional<Post> getPostById(int postId);

    public ArrayList<Post> getPostsByUserId(int userId);
    
}
