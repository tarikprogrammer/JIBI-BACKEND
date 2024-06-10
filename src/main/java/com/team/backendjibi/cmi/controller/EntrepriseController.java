package com.team.backendjibi.cmi.controller;

import com.team.backendjibi.cmi.dto.TransactionDTO;
import com.team.backendjibi.cmi.entity.Entreprise;
import com.team.backendjibi.cmi.services.EntrepriseService;
import com.team.backendjibi.request.EntrepriseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/newEntreprise")
    public boolean createEntreprise(EntrepriseRequest entrepriseRequest){
        return entrepriseService.createEntreprise(entrepriseRequest);
    }






}
