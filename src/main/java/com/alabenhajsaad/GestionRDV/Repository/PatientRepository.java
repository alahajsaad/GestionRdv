package com.alabenhajsaad.GestionRDV.Repository;

import com.alabenhajsaad.GestionRDV.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
