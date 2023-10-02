package com.example.demo.UserController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.hibernate.mapping.List;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.PostDTO;
import com.example.demo.Entity.Post;
import com.example.demo.Entity.User;
import com.example.demo.Service.PostService;
import com.example.demo.Service.UserService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private  ResourceLoader resourceLoader;

    @PostMapping("/save")
    public ResponseEntity<HashMap<String, String>> savePost(@RequestParam int userId, @RequestBody PostDTO postDTO) {
        Optional<User> existingUser = userService.getUserById(userId);

        if (existingUser.isPresent()) {
            Post post = new Post(
                    userId,
                    postDTO.getTopic(),
                    postDTO.getContent(),
                    postDTO.getStartDate(),
                    postDTO.getEndDate(),
                    postDTO.getImageName()
                    );

            int postId = postService.savePost(post);

            // Create a JSON response
            HashMap<String, String> response = new HashMap<>();
            response.put("message", "Post saved successfully with ID: " + postId);

            return ResponseEntity.ok(response);
        } else {
            // Create a JSON error response
            HashMap<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "User with ID " + userId + " not found");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @PutMapping("/update")
public ResponseEntity<?> updatePost(@RequestParam int postId, @RequestBody PostDTO postDTO) {
    Optional<Post> existingPost = postService.getPostById(postId);

    if (existingPost.isPresent()) {
        Post postToUpdate = existingPost.get();

        postToUpdate.setTopic(postDTO.getTopic());
        postToUpdate.setContent(postDTO.getContent());
        postToUpdate.setStartDate(postDTO.getStartDate());
        postToUpdate.setEndDate(postDTO.getEndDate());

        postService.updatePost(postToUpdate);

        HashMap<String, String> response = new HashMap<>();
        response.put("message", "Data Updated Successfully");

        return ResponseEntity.ok(response);
    } else {
        HashMap<String, String> errorResponse  = new HashMap<>();
        errorResponse .put("message", "Data Did not Update Successfully");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
    


    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<ArrayList<Post>> getPostsByUserId(@PathVariable int userId){
        ArrayList<Post> userPosts = postService.getPostsByUserId(userId);

        if(!userPosts.isEmpty()){
            return ResponseEntity.ok(userPosts);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getPostById/{postId}")
    public ResponseEntity<?> getPostById(@PathVariable int postId){
        Optional<Post> existingPost = postService.getPostById(postId);

        if(existingPost.isPresent()){
            return ResponseEntity.ok(existingPost.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }  
    }

    @GetMapping("/image/{imageName}")
    public ResponseEntity<Resource> getImageByPost(@PathVariable String imageName){
        
        Resource imagResource = resourceLoader.getResource("file:uploads/"+ imageName);
        
        if(imagResource.exists()){
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imagResource);
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }
    
}
