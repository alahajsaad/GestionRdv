package com.alabenhajsaad.GestionRDV.Security.Entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(unique = true,nullable = false)
    private String username ;
    private String email ;
    private String password ;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private List<AppRole> roles ;
}
