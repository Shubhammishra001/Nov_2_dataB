package com.w1.dw1.cont;

import com.w1.dw1.entity.User;
import com.w1.dw1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class TestApi {
  @Autowired
    public UserService userService;
    @GetMapping("/list")
    public String Test(){
        return "Test api call ";
    }
    @GetMapping("/user")
    public List<User> getUser(){
        return this.userService.getStore();
    }

}
