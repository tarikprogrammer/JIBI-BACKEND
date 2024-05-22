package com.team.backendjibi.CMI.controllers;

import com.team.backendjibi.CMI.dto.CreancierDTO;
import com.team.backendjibi.CMI.dto.CreancierWithCreancesDTO;
import com.team.backendjibi.CMI.request.CreancierRequest;
import com.team.backendjibi.CMI.services.CreancierService;
import com.team.backendjibi.CMI.services.servicesImpl.CreanceServiceImpl;
import com.team.backendjibi.CMI.services.servicesImpl.CreancierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/creancier")
@CrossOrigin("*")
public class CreancierController {

    @Autowired
    private CreancierServiceImpl creancierService;

    @Autowired
    private CreanceServiceImpl creanceService;
    @GetMapping("/all")
    public ResponseEntity<List<CreancierDTO>> getCreancierWithCreances() {
        List<CreancierDTO> creditors = creancierService.getAllCreanciers();
        return ResponseEntity.ok(creditors);
    }

    @PostMapping("/add")
    public ResponseEntity<CreancierDTO> addCreancier(@RequestBody CreancierRequest creancierRequest) {
        CreancierDTO creancierDTO = creancierService.createCreancier(creancierRequest);
        return new ResponseEntity<>(creancierDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreancierDTO> updateCreancier(@PathVariable Long id, @RequestBody CreancierRequest creancierRequest) {
        CreancierDTO updatedCreancier = creancierService.updateCreancier(id, creancierRequest);
        return ResponseEntity.ok(updatedCreancier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCreancier(@PathVariable Long id) {
        creancierService.deleteCreancier(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreancierDTO> getCreancierById(@PathVariable Long id) {
        CreancierDTO creancierDTO = creancierService.getCreancierById(id);
        return ResponseEntity.ok(creancierDTO);
    }

    @GetMapping("/withCreances/{id}")
    public ResponseEntity<CreancierWithCreancesDTO> getCreancierWithCreances(@PathVariable Long id) {
        CreancierWithCreancesDTO creancierWithCreancesDTO = creancierService.getCreancierWithCreances(id);
        return ResponseEntity.ok(creancierWithCreancesDTO);
    }







}
