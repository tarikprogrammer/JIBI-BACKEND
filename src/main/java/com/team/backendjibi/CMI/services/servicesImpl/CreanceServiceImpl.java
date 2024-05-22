package com.team.backendjibi.CMI.services.servicesImpl;

import com.team.backendjibi.CMI.dto.CreanceDTO;
import com.team.backendjibi.CMI.entity.Creance;
import com.team.backendjibi.CMI.entity.Creancier;
import com.team.backendjibi.CMI.mapper.CreanceMapper;
import com.team.backendjibi.CMI.mapper.CreancierMapper;
import com.team.backendjibi.CMI.repository.CreanceRepository;
import com.team.backendjibi.CMI.repository.CreancierRepository;
import com.team.backendjibi.CMI.request.CreanceRequest;
import com.team.backendjibi.CMI.services.CreanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreanceServiceImpl implements CreanceService {

    @Autowired
    private CreanceRepository creanceRepository;

    @Autowired
    private CreancierRepository creancierRepository;

    @Override
    public CreanceDTO createCreance(Long creancierId, CreanceRequest creanceRequest) {
        Creancier creancier = creancierRepository.findById(creancierId)
                .orElseThrow(() -> new RuntimeException("Creditor not found"));
        Creance creance = new Creance();
        creance.setCodeCreance(creanceRequest.getCodeCreance());
        creance.setNomCreance(creanceRequest.getNomCreance());
        creance.setCreancier(creancier);
        Creance savedCreance = creanceRepository.save(creance);
        return CreanceMapper.toCreanceDTO(savedCreance);
    }

    @Override
    public CreanceDTO updateCreance(Long id, CreanceRequest creanceRequest) {
        Creance existingCreance = creanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Creance not found"));
        existingCreance.setCodeCreance(creanceRequest.getCodeCreance());
        existingCreance.setNomCreance(creanceRequest.getNomCreance());
        Creance updatedCreance = creanceRepository.save(existingCreance);
        return CreanceMapper.toCreanceDTO(updatedCreance);
    }

    @Override
    public void deleteCreance(Long id) {
        creanceRepository.deleteById(id);
    }

    @Override
    public CreanceDTO getCreanceById(Long id) {
        Creance creance = creanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Creance not found"));
        return CreanceMapper.toCreanceDTO(creance);
    }

    @Override
    public List<CreanceDTO> getCreancesByCreancierId(Long creancierId) {
        return creanceRepository.findByCreancierId(creancierId).stream()
                .map(CreanceMapper::toCreanceDTO)
                .collect(Collectors.toList());
    }
}
