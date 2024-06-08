package com.team.backendjibi.cmi.services;

import com.team.backendjibi.cmi.dto.CreancierDto;
import com.team.backendjibi.cmi.entity.CreanceEntity;
import com.team.backendjibi.cmi.entity.CreancierEntity;
import com.team.backendjibi.cmi.repository.CreanceRepo;
import com.team.backendjibi.cmi.repository.CreancierRepo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CreancierServices {
    @Autowired
    private CreancierRepo creancierRepo;
    @Autowired
    CreanceRepo creanceRepo;

    public void createCreancier(){
        CreancierEntity creancier = new CreancierEntity(null,"marocTelecome.png","IAM RECHARGES","10%",null);
        List<CreanceEntity> descriptionEntityList=new ArrayList<>();
        descriptionEntityList.add(new CreanceEntity(null,"TELEPHONE ET INTERNET ","",creancier,null));
        descriptionEntityList.add(new CreanceEntity(null,"SIM","",creancier,null));
        creancier.setCreanceEntities(descriptionEntityList);
        creancierRepo.save(creancier);

        CreancierEntity creancier1 = new CreancierEntity(null,"marocTelecome.png","IAM FACTURES","12%",null);
        descriptionEntityList=new ArrayList<>();
        descriptionEntityList.add(new CreanceEntity(null,"PRODUIT INTERNET SIM","",creancier1,null));
        descriptionEntityList.add(new CreanceEntity(null,"PRODUIT FIXE SIM","",creancier1,null));
        descriptionEntityList.add(new CreanceEntity(null,"PRODUIT MOBILE SIM","",creancier1,null));
        creancier1.setCreanceEntities(descriptionEntityList);
        creancierRepo.save(creancier1);

        CreancierEntity creancier2 = new CreancierEntity(null,"redal.png","REDAL","11.5%",null);
        descriptionEntityList=new ArrayList<>();
        descriptionEntityList.add(new CreanceEntity(null,"FACTURES REDAL","",creancier2,null));
        creancier2.setCreanceEntities(descriptionEntityList);
        creancierRepo.save(creancier2);

        CreancierEntity creancier3 = new CreancierEntity(null,"amendis.jpeg","AMENDIS TANGER","13%",null);
        descriptionEntityList=new ArrayList<>();
        descriptionEntityList.add(new CreanceEntity(null,"FACTURES AMENDIS ","",creancier3,null));
        descriptionEntityList.add(new CreanceEntity(null,"TANGER","",creancier3,null));
        creancier3.setCreanceEntities(descriptionEntityList);
        creancierRepo.save(creancier3);

        CreancierEntity creancier4 = new CreancierEntity(null,"alcs.png","ALCS","14%",null);
        descriptionEntityList=new ArrayList<>();
        descriptionEntityList.add(new CreanceEntity(null,"FACTURES ALCS","",creancier4,null));
        creancier4.setCreanceEntities(descriptionEntityList);
        creancierRepo.save(creancier4);
    }
    public List<CreancierEntity>getAllCreanciers(){
      List<CreancierEntity>creancierEntities=creancierRepo.findAll();
      for(CreancierEntity c:creancierEntities){
          System.out.println(c);

      }
        return creancierEntities;
    }
    public CreancierDto getCreancierInfo(CreancierDto creancierDto){
        CreancierEntity creancierEntity = new CreancierEntity();
        CreanceEntity creance= new CreanceEntity();
        BeanUtils.copyProperties(creancierDto,creance);
        BeanUtils.copyProperties(creancierDto,creancierEntity);
        CreanceEntity getCreance=creanceRepo.findByRef(creance.getRef());
        CreancierEntity isExist=creancierRepo.findByCreanceEntities(getCreance);
        CreancierDto getCreancier= new CreancierDto();
        if(isExist!=null){
            System.out.println(creancierDto.getSolde());
            BeanUtils.copyProperties(isExist,getCreancier);
            BeanUtils.copyProperties(getCreance,getCreancier);
            getCreancier.setSolde(creancierDto.getSolde());
        }
        return getCreancier;
    }
}
