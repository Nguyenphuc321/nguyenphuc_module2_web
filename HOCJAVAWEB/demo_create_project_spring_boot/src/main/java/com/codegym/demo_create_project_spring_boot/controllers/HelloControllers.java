package com.codegym.demo_create_project_spring_boot.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloControllers {
    @GetMapping("/")
    public String testSpringBoot() {
        return "hello";
    }
}
