package com.alabenhajsaad.GestionRDV.Repositories;

import com.alabenhajsaad.GestionRDV.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
