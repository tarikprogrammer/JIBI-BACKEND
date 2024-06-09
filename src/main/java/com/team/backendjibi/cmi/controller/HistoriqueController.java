package com.team.backendjibi.cmi.controller;

import com.team.backendjibi.cmi.dto.HistoriqueDto;
import com.team.backendjibi.cmi.services.HistoriqueServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/jibi/")
public class HistoriqueController {
    @Autowired
    private HistoriqueServices historiqueServices;
    @PostMapping("createHistorique")
    public HistoriqueDto createHistorique(@RequestBody HistoriqueDto historiqueDto){
        return historiqueServices.createHistorique(historiqueDto);
    }
    @PostMapping("historiques")
    public List<HistoriqueDto> getHistoriques(@RequestBody HistoriqueDto historiqueDto){
      return historiqueServices.historiques(historiqueDto);
    }
}
