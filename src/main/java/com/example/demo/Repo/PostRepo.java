package com.example.demo.Repo;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Post;
import com.example.demo.Entity.User;

@EnableJpaRepositories
@Repository
public interface PostRepo extends JpaRepository<Post,Integer>{

    ArrayList<Post> findByUserId(int id);
    
}
