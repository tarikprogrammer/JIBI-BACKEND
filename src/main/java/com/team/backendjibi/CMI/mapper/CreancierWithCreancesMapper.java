package com.team.backendjibi.CMI.mapper;

import com.team.backendjibi.CMI.dto.CreanceDTO;
import com.team.backendjibi.CMI.dto.CreancierDTO;
import com.team.backendjibi.CMI.dto.CreancierWithCreancesDTO;
import com.team.backendjibi.CMI.entity.Creance;
import com.team.backendjibi.CMI.entity.Creancier;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class CreancierWithCreancesMapper {

    public static CreancierWithCreancesDTO toCreancierWithCreancesDTO(Creancier creancier) {
        CreancierWithCreancesDTO creancierWithCreancesDTO = new CreancierWithCreancesDTO();
        BeanUtils.copyProperties(creancier, creancierWithCreancesDTO);

        List<CreanceDTO> creanceDTOList = creancier.getListCreances().stream()
                .map(CreanceMapper::toCreanceDTO)
                .collect(Collectors.toList());
        creancierWithCreancesDTO.setListCreances(creanceDTOList);

        return creancierWithCreancesDTO;
    }

    public static Creancier toEntity(CreancierWithCreancesDTO creancierWithCreancesDTO) {
        Creancier creancier = new Creancier();
        BeanUtils.copyProperties(creancierWithCreancesDTO, creancier);

        List<Creance> creances = creancierWithCreancesDTO.getListCreances().stream()
                .map(CreanceMapper::toEntity)
                .collect(Collectors.toList());
        creancier.setListCreances(creances);

        return creancier;
    }
}
