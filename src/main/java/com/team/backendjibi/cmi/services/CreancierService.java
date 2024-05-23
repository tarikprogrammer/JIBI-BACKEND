package com.team.backendjibi.CMI.services;

import com.team.backendjibi.CMI.dto.CreancierDTO;
import com.team.backendjibi.CMI.dto.CreancierWithCreancesDTO;
import com.team.backendjibi.CMI.request.CreancierRequest;

import java.util.List;

public interface CreancierService {

    CreancierDTO createCreancier(CreancierRequest creancierRequest);

    CreancierDTO updateCreancier(Long id, CreancierRequest creancierRequest);

    void deleteCreancier(Long id);

    CreancierDTO getCreancierById(Long id);

    List<CreancierDTO> getAllCreanciers();

    CreancierWithCreancesDTO getCreancierWithCreances(Long id);
}
