package com.team.backendjibi.servicesJibi;

import com.team.backendjibi.dto.AdminDto;
import com.team.backendjibi.repositoryJibi.repoEntities.RepoAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAdmin {
    @Autowired
    private RepoAdmin repo;
    public boolean adminLogin(AdminDto adminDto){
        return false;
    }
}
