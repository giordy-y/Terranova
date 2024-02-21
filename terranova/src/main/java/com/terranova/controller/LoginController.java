package com.terranova.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("home")
    public String Home(){
        return "this is the homepage";
    }
    @GetMapping("Admin")
    public String Admin(){
        return "this is the Adminpage";
    }
}
