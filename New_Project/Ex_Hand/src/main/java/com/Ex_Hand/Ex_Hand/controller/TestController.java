package com.Ex_Hand.Ex_Hand.controller;

import com.Ex_Hand.Ex_Hand.repo.TestRepo;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")

public class TestController {

@Autowired
    private TestRepo testRepo;




}
