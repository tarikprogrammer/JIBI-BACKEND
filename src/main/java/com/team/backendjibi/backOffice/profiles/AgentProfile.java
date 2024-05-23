
package com.team.backendjibi.backOffice.profiles;

import com.team.backendjibi.backOffice.entities.AgentEntity;
import com.team.backendjibi.shared.GeneratePassword;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="agentProfile")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class AgentProfile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Column(nullable = false)
    private String password;
    private String email;
    private String imageUrl;
    private String phone;
    @PrePersist
    public void generatePassword(){
        if(this.password==null){
            this.password= GeneratePassword.genererPassword();
        }
    }
    @OneToOne
    @JoinColumn(name="agent_id",foreignKey = @ForeignKey(name="id"),referencedColumnName = "id")
    private AgentEntity agent;

}
