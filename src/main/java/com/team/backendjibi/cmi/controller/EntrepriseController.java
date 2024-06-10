package com.team.backendjibi.cmi.controller;

import com.team.backendjibi.cmi.dto.TransactionDTO;
import com.team.backendjibi.cmi.entity.Entreprise;
import com.team.backendjibi.cmi.services.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/jibi/")
public class EntrepriseController {

    @Autowired
    EntrepriseService entrepriseService;



    @GetMapping("/allEntreprises")
    public List<Entreprise> getAllEntreprises() {
        return entrepriseService.getAllEntreprises();
    }






}
