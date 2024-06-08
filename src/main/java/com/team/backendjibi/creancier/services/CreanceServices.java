package com.team.backendjibi.creancier.services;

import com.team.backendjibi.creancier.dto.CreancierDto;
import com.team.backendjibi.creancier.entities.CreanceEntity;
import com.team.backendjibi.creancier.entities.CreancierEntity;
import com.team.backendjibi.creancier.repo.CreanceRepo;
import com.team.backendjibi.creancier.repo.CreancierRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreanceServices {
    @Autowired
    private CreanceRepo creanceRepo;
    @Autowired
    private CreancierRepo creancierRepo;

    public CreancierDto getInfoCreance(CreancierDto creancierDto){
        CreanceEntity creanceEntity = new CreanceEntity();
        CreancierDto responseCreancier= new CreancierDto();
        BeanUtils.copyProperties(creancierDto,creanceEntity);
        CreancierEntity creancierEntity =new CreancierEntity();
        CreanceEntity isCreanceExist=creanceRepo.findByCreance(creanceEntity.getCreance());
        if(isCreanceExist!=null){
            creancierEntity=creancierRepo.findByCreanceEntities(isCreanceExist);
            BeanUtils.copyProperties(creancierEntity,responseCreancier);
            BeanUtils.copyProperties(isCreanceExist,responseCreancier);

        }
        return responseCreancier;
    }
}
