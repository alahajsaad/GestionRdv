package com.alabenhajsaad.GestionRDV.Repository;

import com.alabenhajsaad.GestionRDV.Entities.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface RdvRepository extends JpaRepository<Rdv ,Integer> {
    Rdv findByPatientIdAndDateRdv(int id , LocalDateTime date) ;
    Rdv findByMedecinIdAndDateRdv(int id , LocalDateTime date) ;
    List<Rdv> findByDateRdvBetween(LocalDateTime startOfDay, LocalDateTime endOfDay);
}