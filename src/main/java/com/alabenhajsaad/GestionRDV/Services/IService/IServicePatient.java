package com.alabenhajsaad.GestionRDV.Services.IService;

import com.alabenhajsaad.GestionRDV.Entities.Patient;

import java.util.List;

public interface IServicePatient {
    public Patient AddPatient(Patient p) ;
    public List<Patient> GetAllPatients () ;
    public void Delete(int id) ;
}
