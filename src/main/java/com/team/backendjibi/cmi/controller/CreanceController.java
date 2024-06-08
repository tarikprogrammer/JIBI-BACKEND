package com.team.backendjibi.cmi.controller;

import com.team.backendjibi.cmi.dto.CreancierDto;
import com.team.backendjibi.cmi.services.CreanceServices;
import com.team.backendjibi.cmi.services.CreancierServices;
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