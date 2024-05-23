package com.team.backendjibi.CMI.mapper;

import com.team.backendjibi.CMI.dto.CreanceDTO;
import com.team.backendjibi.CMI.entity.Creance;
import org.springframework.beans.BeanUtils;

public class CreanceMapper {
    public static CreanceDTO toCreanceDTO(Creance creance) {
        CreanceDTO creanceDTO = new CreanceDTO();
        BeanUtils.copyProperties(creance,creanceDTO);
        return creanceDTO;
    }
    public static Creance toEntity(CreanceDTO creanceDTO) {
        Creance creance = new Creance();
        BeanUtils.copyProperties(creanceDTO,creance);
        return creance;
    }
}
