package com.example.springmock.Controllers;

import com.example.springmock.Models.User;
import com.example.springmock.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/addUser")
    public String addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }
}
