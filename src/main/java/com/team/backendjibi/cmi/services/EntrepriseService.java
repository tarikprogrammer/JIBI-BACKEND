package com.team.backendjibi.cmi.services;

import com.team.backendjibi.cmi.entity.Entreprise;
import com.team.backendjibi.cmi.repository.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrepriseService {

    @Autowired
    private EntrepriseRepository entrepriseRepository ;

    public boolean createEntreprise(Long clientId){
        if(clientId==null){
            return false;
        }
        Entreprise entreprise =  Entreprise.builder().ClientId(clientId).build();
        entrepriseRepository.save(entreprise);
        return true;
    }

    public Entreprise getEntrepriseByClientId(Long clientId){
        return entrepriseRepository.findEntrepriseByClientId(clientId);
    }

    public List<Entreprise> getAllEntreprises(){
        return entrepriseRepository.findAll();
    }




}
