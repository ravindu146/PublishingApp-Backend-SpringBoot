package com.example.demo.Service;


import java.util.Optional;

import  com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Entity.User;
import com.example.demo.Response.LoginResponse;

public interface UserService {
    public String addUser(UserDTO userDTO);

    public LoginResponse loginUser(LoginDTO loginDTO);

    public boolean checkEmailExists(String email);

    public Optional<User> getUserByEmail(String email);

    public void UpdateUser(User userToUpdate);

    public Optional<User> getUserById( int userId);
}
