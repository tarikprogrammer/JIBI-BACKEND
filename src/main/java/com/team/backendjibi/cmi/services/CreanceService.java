package com.team.backendjibi.CMI.services;

import com.team.backendjibi.CMI.dto.CreanceDTO;
import com.team.backendjibi.CMI.request.CreanceRequest;

import java.util.List;

public interface CreanceService {
    CreanceDTO createCreance(Long creancierId, CreanceRequest creanceRequest);

    CreanceDTO updateCreance(Long id, CreanceRequest creanceRequest);

    void deleteCreance(Long id);

    CreanceDTO getCreanceById(Long id);

    List<CreanceDTO> getCreancesByCreancierId(Long creancierId);
}
