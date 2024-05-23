package com.team.backendjibi.servicesJibi;

import com.team.backendjibi.agence.AgenceEntity;
import com.team.backendjibi.backOffice.entities.AgentEntity;
import com.team.backendjibi.backOffice.profiles.AgentProfile;
import com.team.backendjibi.dto.AgentDto;
import com.team.backendjibi.repositoryJibi.repoEntities.RepoAgence;
import com.team.backendjibi.repositoryJibi.repoEntities.RepoAgent;
import com.team.backendjibi.repositoryJibi.repoProfiles.RepoProfileAgent;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Transactional
@Service
public class AgentService {
    @Autowired
    private RepoAgent repoAgent;
    @Autowired
    private RepoAgence repoAgence;
    private AgenceEntity agenceEntity = AgenceEntity.builder()
            .agenceName("JIBI")
            .build();
    @Autowired
    private RepoProfileAgent repoProfileAgent;

    public AgentDto createAgent(AgentDto agentDto) throws Exception {
      AgentEntity agent = new AgentEntity();
      BeanUtils.copyProperties(agentDto,agent);
      AgentProfile agentProfile = new AgentProfile();
      BeanUtils.copyProperties(agentDto,agentProfile);
      /*verify phone number should be unique */
      AgentProfile verifyPhone=repoProfileAgent.findByPhone(agentProfile.getPhone());

      if(verifyPhone!=null){
          throw new Exception("phone number est deja exist");
      }
        AgenceEntity existingAgence = repoAgence.findByAgenceName("JIBI");
        if (existingAgence == null) {
            existingAgence = repoAgence.save(agenceEntity);
        }
        AgentEntity newAgent =new AgentEntity();
        /*-------------- set info for profile agent ----------*/
        agent.setAgence(existingAgence);
        agentProfile.setAgent(agent);
        agent.setAgentProfile(agentProfile);
        if(Objects.equals(agent.getNumero_patente(), existingAgence.getNumeroPattente())){
            System.out.println("tarik service agent is here");
            newAgent=repoAgent.save(agent);
        }
      AgentDto agentDtoCreated=new AgentDto();
      BeanUtils.copyProperties(newAgent,agentDtoCreated);
      BeanUtils.copyProperties(newAgent.getAgentProfile(),agentDtoCreated);
      System.out.println(agentDtoCreated);
      return agentDtoCreated;
    }

    public boolean loginAgent(AgentDto agentDto) {
        AgentProfile agent = new AgentProfile();
        BeanUtils.copyProperties(agentDto,agent);
        boolean[] isExist={false};
       repoProfileAgent.findAll().forEach(element ->{
             if(element.getPhone().equals(agent.getPhone()) && element.getPassword().equals(agent.getPassword())){
                 isExist[0]=true;
             }

        });
       return isExist[0];
    }
    /*get current agent logged*/
    public AgentDto getAgent(AgentDto agentDto){
        AgentDto getAgent = new AgentDto();
        boolean isExist=loginAgent(agentDto);
        List<AgentProfile> agentEntity = repoProfileAgent.findAll();
        if(isExist){
            BeanUtils.copyProperties(agentEntity.stream()
                    .filter(c -> c.getPassword().equals(agentDto.getPassword()) && c.getPhone().equals(agentDto.getPhone())).collect(Collectors.toList()).get(0),getAgent);
        }
        return getAgent;
    }
    public boolean updatePassword(AgentDto agentDto){
        AgentProfile agent = new AgentProfile();
        BeanUtils.copyProperties(agentDto,agent);
        boolean status=false;
         AgentProfile agent1 =repoProfileAgent.findByPhone(agent.getPhone());
        if(agent1!=null){
            agent1.setPassword(agent.getPassword());
            agent =repoProfileAgent.save(agent1);
            status=true;
        }
        return status;

    }
}
