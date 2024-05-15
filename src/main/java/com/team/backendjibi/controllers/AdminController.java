package com.team.backendjibi.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/jibi/admin/")
public class AdminController {
    @PostMapping("/login")
    public boolean login(){
        return false;
    }
}
