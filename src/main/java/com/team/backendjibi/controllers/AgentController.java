package com.team.backendjibi.controllers;

import com.team.backendjibi.dto.AgentDto;
import com.team.backendjibi.dto.ClientDto;
import com.team.backendjibi.repositoryJibi.repoEntities.RepoClient;
import com.team.backendjibi.request.RequestAgent;
import com.team.backendjibi.request.RequestClient;
import com.team.backendjibi.servicesJibi.AgentService;
import com.team.backendjibi.servicesJibi.ServiceClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/jibi/")
@CrossOrigin("*")
public class AgentController {
    @Autowired
    private AgentService agentService;
    @Autowired
    private ServiceClient serviceClient;
    @Autowired
    private RepoClient repoClient;

    @PostMapping("/backOffice/register")
    public RequestAgent createAgent(@RequestBody RequestAgent requestAgent) throws Exception {
        AgentDto agentDto = new AgentDto();
        BeanUtils.copyProperties(requestAgent,agentDto);
        AgentDto agentCreated=agentService.createAgent(agentDto);
        RequestAgent requestAgent1 = new RequestAgent();
        BeanUtils.copyProperties(agentCreated,requestAgent1);
        return requestAgent1;
    }
    @PostMapping("/backOffice/login")
    public AgentDto loginAgent(@RequestBody RequestAgent requestAgent){
        AgentDto agentDto = new AgentDto();
        BeanUtils.copyProperties(requestAgent,agentDto);
        AgentDto getAgent =agentService.getAgent(agentDto);
        return getAgent;

    }
    @PostMapping("backOffice/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        System.out.println("for testttt");
        try {
            String uploadDir = "C:\\Users\\pc\\Downloads\\ProjetPFSJibi-main\\ProjetPFSJibi-main\\frontend\\src\\assets\\images";
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            file.transferTo(new File(uploadDir + File.separator + file.getOriginalFilename()));
            return ResponseEntity.ok("Image uploaded successfully");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading image");
        }
    }
    @PostMapping("/backOffice/client/register")
    public boolean createClient(@RequestBody RequestClient requestClient){
        ClientDto clientDto = new ClientDto();
        BeanUtils.copyProperties(requestClient,clientDto);
        return serviceClient.create(clientDto);
    }
    @PutMapping("/backOffice/update")
    public boolean updateAgent(@RequestBody RequestAgent requestAgent){
        System.out.println("teststtsttst passs");
        AgentDto agentDto = new AgentDto();
        BeanUtils.copyProperties(requestAgent,agentDto);
        return agentService.updatePassword(agentDto);
    }
    @GetMapping("/backOffice/clients")
    public List<ClientDto> getAll(){
        System.out.println("for test");
        List<ClientDto>clients=serviceClient.getAllClient();
        return clients;
    }
}
