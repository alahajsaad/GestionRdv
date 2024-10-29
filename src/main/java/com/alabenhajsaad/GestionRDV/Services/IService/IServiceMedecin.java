package com.alabenhajsaad.GestionRDV.Services.IService;

import com.alabenhajsaad.GestionRDV.Entities.Medecin;

import java.util.List;

public interface IServiceMedecin {
    public Medecin AddMedecin(Medecin M) ;
    public List<Medecin> GetAllMedecins () ;
    public void Delete(int id) ;
}