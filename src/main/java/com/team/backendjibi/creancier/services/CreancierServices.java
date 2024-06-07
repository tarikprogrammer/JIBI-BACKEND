package com.team.backendjibi.creancier.services;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.team.backendjibi.creancier.dto.CreancierDto;
import com.team.backendjibi.creancier.entities.CreancierEntity;
import com.team.backendjibi.creancier.entities.DescriptionEntity;
import com.team.backendjibi.creancier.repo.CreancierRepo;
import com.team.backendjibi.creancier.repo.DescriptionRepo;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CreancierServices {
    @Autowired
    private CreancierRepo creancierRepo;
    @Autowired
    DescriptionRepo descriptionRepo;

    public void createCreancier(){
        CreancierEntity creancier = new CreancierEntity(null,"marocTelecome.png","IAM RECHARGES","10%",null,null);
        List<DescriptionEntity> descriptionEntityList=new ArrayList<>();
        descriptionEntityList.add(new DescriptionEntity(null,"TELEPHONE ET INTERNET ",creancier));
        descriptionEntityList.add(new DescriptionEntity(null,"SIM",creancier));
        creancier.setDescriptionEntities(descriptionEntityList);
        creancierRepo.save(creancier);

        CreancierEntity creancier1 = new CreancierEntity(null,"marocTelecome.png","IAM FACTURES","12%",null,null);
         descriptionEntityList=new ArrayList<>();
        descriptionEntityList.add(new DescriptionEntity(null,"PRODUIT INTERNET SIM",creancier1));
        descriptionEntityList.add(new DescriptionEntity(null,"PRODUIT FIXE SIM",creancier1));
        descriptionEntityList.add(new DescriptionEntity(null,"PRODUIT MOBILE SIM",creancier1));
        creancier1.setDescriptionEntities(descriptionEntityList);
        creancierRepo.save(creancier1);

        CreancierEntity creancier2 = new CreancierEntity(null,"redal.png","REDAL","11.5%",null,null);
        descriptionEntityList=new ArrayList<>();
        descriptionEntityList.add(new DescriptionEntity(null,"FACTURES REDAL",creancier2));
        creancier2.setDescriptionEntities(descriptionEntityList);
        creancierRepo.save(creancier2);

        CreancierEntity creancier3 = new CreancierEntity(null,"amendis.jpeg","AMENDIS TANGER","13%",null,null);
        descriptionEntityList=new ArrayList<>();
        descriptionEntityList.add(new DescriptionEntity(null,"FACTURES AMENDIS ",creancier3));
        descriptionEntityList.add(new DescriptionEntity(null,"TANGER",creancier3));
        creancier3.setDescriptionEntities(descriptionEntityList);
        creancierRepo.save(creancier3);

        CreancierEntity creancier4 = new CreancierEntity(null,"alcs.png","ALCS","14%",null,null);
        descriptionEntityList=new ArrayList<>();
        descriptionEntityList.add(new DescriptionEntity(null,"FACTURES ALCS",creancier4));
        creancier4.setDescriptionEntities(descriptionEntityList);
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
        BeanUtils.copyProperties(creancierDto,creancierEntity);
        CreancierEntity isExist=creancierRepo.findByRef(creancierEntity.getRef());
        CreancierDto getCreancier= new CreancierDto();
        if(isExist!=null){
            System.out.println(creancierDto.getSolde());
            BeanUtils.copyProperties(isExist,getCreancier);
            getCreancier.setSolde(creancierDto.getSolde());
        }
        return getCreancier;
    }
}
