package com.team.backendjibi.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ClientDto {
    private Long id;
    private String fname;
    private String lname;
    private String piece_identite;
    private String numeroDePieceIdentite;
    private String addresse;
    private String email;
    private String phone;
    private String file;
    private String password;
    private String cover;
   /* private String accounttype;*/

}
