package com.alabenhajsaad.GestionRDV.Security.Entites;

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
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(unique = true , nullable = false)
    private String role ;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private List<AppUser> userList ;
}
