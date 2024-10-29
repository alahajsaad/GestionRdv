package com.alabenhajsaad.GestionRDV.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String nom ;
    private String prenom ;
    private String specialite ;
    private String adresse ;

    @OneToMany(mappedBy = "medecin")
    @JsonIgnore
    private List<Rdv> rdvs;
}
