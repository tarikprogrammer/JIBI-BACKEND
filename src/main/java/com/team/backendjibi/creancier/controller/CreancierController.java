package com.team.backendjibi.creancier.controller;

import com.team.backendjibi.creancier.dto.CreancierDto;
import com.team.backendjibi.creancier.entities.CreancierEntity;
import com.team.backendjibi.creancier.services.CreancierServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jibi/")
@CrossOrigin("*")
public class CreancierController {
    @Autowired
    private CreancierServices creancierServices;
    @GetMapping("creancier/list")
    public List<CreancierEntity>creanciers(){
        return creancierServices.getAllCreanciers();
    }
}
