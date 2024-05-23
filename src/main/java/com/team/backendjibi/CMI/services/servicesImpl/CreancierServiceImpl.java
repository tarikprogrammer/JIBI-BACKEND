package com.team.backendjibi.CMI.services.servicesImpl;

import com.team.backendjibi.CMI.dto.CreancierDTO;
import com.team.backendjibi.CMI.dto.CreancierWithCreancesDTO;
import com.team.backendjibi.CMI.entity.Creancier;
import com.team.backendjibi.CMI.mapper.CreancierWithCreancesMapper;
import com.team.backendjibi.CMI.repository.CreancierRepository;
import com.team.backendjibi.CMI.mapper.CreancierMapper;

import com.team.backendjibi.CMI.request.CreancierRequest;
import com.team.backendjibi.CMI.services.CreancierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreancierServiceImpl implements CreancierService {

    @Autowired
    private CreancierRepository creancierRepository;

    @Override
    public CreancierDTO createCreancier(CreancierRequest creancierRequest) {
        Creancier creancier = new Creancier();
        creancier.setNomCreancier(creancierRequest.getNomCreancier());
        creancier.setImageUrl(creancierRequest.getImageUrl());
        creancier.setCodeCreancier(creancierRequest.getCodeCreancier());
        creancier.setCategorie(creancierRequest.getCategorie());
        Creancier savedCreancier = creancierRepository.save(creancier);
        return CreancierMapper.toCreancierDTO(savedCreancier);
    }

    @Override
    public CreancierDTO updateCreancier(Long id, CreancierRequest creancierRequest) {
        Creancier existingCreancier = creancierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Creancier not found"));
        existingCreancier.setNomCreancier(creancierRequest.getNomCreancier());
        existingCreancier.setImageUrl(creancierRequest.getImageUrl());
        existingCreancier.setCodeCreancier(creancierRequest.getCodeCreancier());
        existingCreancier.setCategorie(creancierRequest.getCategorie());
        Creancier updatedCreancier = creancierRepository.save(existingCreancier);
        return CreancierMapper.toCreancierDTO(updatedCreancier);
    }

    @Override
    public void deleteCreancier(Long id) {
        creancierRepository.deleteById(id);
    }

    @Override
    public CreancierDTO getCreancierById(Long id) {
        Creancier creancier = creancierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Creancier not found"));
        return CreancierMapper.toCreancierDTO(creancier);
    }

    @Override
    public List<CreancierDTO> getAllCreanciers() {
        return creancierRepository.findAll().stream()
                .map(CreancierMapper::toCreancierDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CreancierWithCreancesDTO getCreancierWithCreances(Long id) {
        Creancier creancier = creancierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Creancier not found"));
        return CreancierWithCreancesMapper.toCreancierWithCreancesDTO(creancier);
    }
}

