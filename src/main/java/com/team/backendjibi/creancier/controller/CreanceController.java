package com.team.backendjibi.creancier.controller;

import com.team.backendjibi.creancier.dto.CreancierDto;
import com.team.backendjibi.creancier.services.CreanceServices;
import com.team.backendjibi.creancier.services.CreancierServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/jibi/")
public class CreanceController {
    @Autowired
    private CreanceServices creanceServices;
    @PostMapping("creance/creanceInfo")
    public CreancierDto getCreance(@RequestBody CreancierDto creancierDto){
        return creanceServices.getInfoCreance(creancierDto);
    }
}
