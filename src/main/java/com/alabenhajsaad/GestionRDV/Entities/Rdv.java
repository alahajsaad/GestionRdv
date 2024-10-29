package com.alabenhajsaad.GestionRDV.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Rdv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , shape = JsonFormat.Shape.STRING)
    private LocalDateTime dateRdv;
    private String etat;

    @ManyToOne

    private Patient patient;

    @ManyToOne

    private Medecin medecin ;
}
