package com.team.backendjibi.servicesJibi;

import com.team.backendjibi.agence.AgenceEntity;
import com.team.backendjibi.backOffice.AgentEntity;
import com.team.backendjibi.dto.AgentDto;
import com.team.backendjibi.repositoryJibi.RepoAgence;
import com.team.backendjibi.repositoryJibi.RepoAgent;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgentService {
    @Autowired
    private RepoAgent repoAgent;
    @Autowired
    private RepoAgence repoAgence;
    private AgenceEntity agenceEntity = AgenceEntity.builder()
            .agenceName("JIBI")
            .build();

    public AgentDto createAgent(AgentDto agentDto) throws Exception {
      AgentEntity agent = new AgentEntity();
      BeanUtils.copyProperties(agentDto,agent);
      /*verify phone number should be unique */
      AgentEntity verifyPhone=repoAgent.findByPhone(agent.getPhone());

      if(verifyPhone!=null){
          throw new Exception("phone number est deja exist");
      }
        AgenceEntity existingAgence = repoAgence.findByAgenceName("JIBI");
        if (existingAgence == null) {
            existingAgence = repoAgence.save(agenceEntity);
        }
        agent.setAgence(existingAgence);
      AgentEntity newAgent = repoAgent.save(agent);
      AgentDto agentDtoCreated=new AgentDto();
      BeanUtils.copyProperties(newAgent,agentDtoCreated);
      return agentDtoCreated;
    }

    public boolean loginAgent(AgentDto agentDto) {
        AgentEntity agent = new AgentEntity();
        BeanUtils.copyProperties(agentDto,agent);
        boolean[] isExist={false};
       repoAgent.findAll().forEach(element ->{
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
        List<AgentEntity> agentEntity = repoAgent.findAll();
        if(isExist){
            BeanUtils.copyProperties( agentEntity.stream()
                    .filter(c -> c.getPassword().equals(agentDto.getPassword()) && c.getPhone().equals(agentDto.getPhone())).collect(Collectors.toList()).get(0),getAgent);
        }
        return getAgent;
    }
    public boolean updatePassword(AgentDto agentDto){
        AgentEntity agent = new AgentEntity();
        BeanUtils.copyProperties(agentDto,agent);
        boolean status=false;
        AgentEntity agent1 =repoAgent.findByPhone(agent.getPhone());
        if(agent1!=null){
            agent1.setPassword(agent.getPassword());
            agent = repoAgent.save(agent1);
            status=true;
        }
        return status;

    }
}
