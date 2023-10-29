package com.example.springmock.Services;

import com.example.springmock.Models.User;
import com.example.springmock.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    public String addUser(User user)
    {
        userRepo.save(user);
        return "added";
    }
}
