package com.team.backendjibi.dto;

import lombok.*;

import java.io.File;
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder @ToString
public class AgentDto {
    private Long id;
    private String fname;
    private String lname;
    private String piece_identite;
    private String numeroDePieceIdentite;
    private String date_naissance;
    private String addresse;
    private String email;
    private String phone;
    private String numero_imm;
    private String numero_patente;
    private String file;
    private boolean agent;
    private String username;
    private String imageUrl;
    private String password;
}
