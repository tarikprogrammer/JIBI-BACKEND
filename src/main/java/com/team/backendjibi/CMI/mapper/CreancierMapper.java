package com.team.backendjibi.CMI.mapper;

import com.team.backendjibi.CMI.dto.CreancierDTO;
import com.team.backendjibi.CMI.entity.Creancier;
import org.springframework.beans.BeanUtils;

public class CreancierMapper {

    public static CreancierDTO toCreancierDTO(Creancier creancier) {
        CreancierDTO creancierDTO = new CreancierDTO();
        BeanUtils.copyProperties(creancier, creancierDTO);
        return creancierDTO;
    }

    public static Creancier toEntity(CreancierDTO creancierDTO) {
        Creancier creancier = new Creancier();
        BeanUtils.copyProperties(creancierDTO, creancier);
        return creancier;
    }


}

