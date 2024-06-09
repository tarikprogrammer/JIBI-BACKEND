package com.team.backendjibi.cmi.services;

import com.team.backendjibi.backOffice.entities.ClientEntity;
import com.team.backendjibi.backOffice.profiles.ClientProfile;
import com.team.backendjibi.cmi.dto.HistoriqueDto;
import com.team.backendjibi.cmi.entity.HistoriquesEntity;
import com.team.backendjibi.cmi.repository.HistoriqueRepo;
import com.team.backendjibi.repositoryJibi.repoEntities.RepoClient;
import com.team.backendjibi.repositoryJibi.repoProfiles.RepoProfileClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class HistoriqueServices {
    @Autowired
    private HistoriqueRepo historiqueRepo;
    @Autowired
    private RepoClient repoClient;
    @Autowired
    private RepoProfileClient repoProfileClient;

    public HistoriqueDto createHistorique(HistoriqueDto historiqueDto){
        HistoriqueDto createdHistorique= new HistoriqueDto();
        ClientProfile clientProfile = repoProfileClient.findByPhone(historiqueDto.getPhone());
        ClientEntity clientEntity =repoClient.findById(clientProfile.getClientId()).get();
        HistoriquesEntity historiquesEntity = new HistoriquesEntity();
        BeanUtils.copyProperties(historiqueDto,historiquesEntity);
        LocalDateTime dateCreated = LocalDateTime.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = dateCreated.format(formatDate);
        historiquesEntity.setDate(formattedDate);
        historiquesEntity.setClient(clientEntity);
        HistoriquesEntity created=historiqueRepo.save(historiquesEntity);
        BeanUtils.copyProperties(created,createdHistorique);
        createdHistorique.setPhone(historiqueDto.getPhone());
        createdHistorique.setFname(historiqueDto.getFname());
        return createdHistorique;
    }
   public List<HistoriqueDto> historiques(HistoriqueDto historiqueDto) {
       ClientProfile clientProfile = repoProfileClient.findByPhone(historiqueDto.getPhone());
       List<HistoriquesEntity> historiquesEntity = historiqueRepo.findByClientId(clientProfile.getClientId());
       List<HistoriqueDto>getList=new ArrayList<>();
       for(HistoriquesEntity hist:historiquesEntity){
           HistoriqueDto response = new HistoriqueDto();
           BeanUtils.copyProperties(hist,response);
           getList.add(response);
       }
       return getList;
   }
}

