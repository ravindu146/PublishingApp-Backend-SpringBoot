package com.example.demo.Service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.PostDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Entity.Post;
import com.example.demo.Entity.User;
import com.example.demo.Repo.UserRepo;
import com.example.demo.Response.LoginResponse;
import com.example.demo.Service.UserService;
import com.example.demo.Service.JwtService;

@Service
public class UserIMPL implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtService jwtService;

    @Override
    public String addUser(UserDTO userDTO) {

        User user = new User(
                userDTO.getName(),
                userDTO.getEmail(),
                userDTO.getMobile(),
                userDTO.getPassword());
        userRepo.save(user);

        return user.getName();
    }

    @Override
    public Optional<User> getUserById(int userId) {
        return userRepo.findOneByUserId(userId);
    }

    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {
        User user1 = userRepo.findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String savedPassword = user1.getPassword();
            int userId = user1.getUserId();
            String email = user1.getEmail();

            Boolean isPwdRight = password.equals(savedPassword);

            if (isPwdRight) {
                String userIdInString =String.valueOf(user1.getUserId());
                String name = user1.getName();
                String authToken = this.jwtService.generateToken(userIdInString);
                Optional<User> user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), savedPassword);
                if (user.isPresent()) {
                    return new LoginResponse("Login Success", true, authToken, userId, name , email);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("Password Not match", false);
            }
        } else {
            return new LoginResponse("Email not exists", false);
        }
    }

    @Override
    public boolean checkEmailExists(String email) {
        User user = userRepo.findByEmail(email);
        return user != null;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepo.findOneByEmail(email);
    }

    @Override
    public void UpdateUser(User userToUpdate) {
        userRepo.save(userToUpdate);
    }
}