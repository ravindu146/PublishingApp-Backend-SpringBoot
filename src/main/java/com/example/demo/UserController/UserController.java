package com.example.demo.UserController;

import java.util.HashMap;
import java.util.Optional;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.PostDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Entity.Post;
import com.example.demo.Entity.User;
import com.example.demo.Response.LoginResponse;
import com.example.demo.Service.PostService;
import com.example.demo.Service.UserService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    // Saving a new User
    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserDTO userDTO) {
        // System.out.println("USer Registration is working");
        String id = userService.addUser(userDTO);
        return id;
    }

    // Update the existing user
    @PutMapping(path = "/update")
    public ResponseEntity<?> updateUser(@RequestParam String email, @RequestBody UserDTO updatedUserDTO) {
        Optional<User> existingUser = userService.getUserByEmail(email);

        if (existingUser.isPresent()) {
            User userToUpdate = existingUser.get();
            userToUpdate.setEmail(updatedUserDTO.getEmail());
            userToUpdate.setName(updatedUserDTO.getName());
            userToUpdate.setMobile(updatedUserDTO.getMobile());
            userToUpdate.setPassword(updatedUserDTO.getPassword());

            userService.UpdateUser(userToUpdate);

            HashMap<String, String> response = new HashMap<>();
            response.put("message", "User Updated successfully!");

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    // login 
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
        LoginResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping(path = "/checkexists")
    public ResponseEntity<Boolean> checkIfEmailExists(@RequestParam String email) {
        boolean emailExists = userService.checkEmailExists(email);
        return ResponseEntity.ok(emailExists);
    }


    // Getting the user by Email
    @GetMapping(path = "/getuser")
    public ResponseEntity<?> getUserByEmail(@RequestParam String email) {
        Optional<User> user = userService.getUserByEmail(email);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Getting the userId with Email
    @GetMapping(path = "/getUserIdByEmail")
    public ResponseEntity<Integer> getUserIdByEmail(@RequestParam String email) {
        Optional<User> user = userService.getUserByEmail(email);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get().getUserId());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
