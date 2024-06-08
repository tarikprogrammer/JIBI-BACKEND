package com.team.backendjibi.cmi.controller;

import com.team.backendjibi.cmi.dto.CreancierDto;
import com.team.backendjibi.cmi.entity.CreancierEntity;
import com.team.backendjibi.cmi.services.CreancierServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/creancier/getCreancierInfo")
    public CreancierDto getCreancierInfo(@RequestBody CreancierDto creancierDto){
        return creancierServices.getCreancierInfo(creancierDto);
    }
}
