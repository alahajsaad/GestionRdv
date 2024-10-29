package com.alabenhajsaad.GestionRDV.Services;

import com.alabenhajsaad.GestionRDV.Entities.Medecin;
import com.alabenhajsaad.GestionRDV.Repositories.MedecinRepository;
import com.alabenhajsaad.GestionRDV.Services.IService.IServiceMedecin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceMedecin implements IServiceMedecin {
    private final MedecinRepository repository ;

    @Override
    public Medecin AddMedecin(Medecin M) {
        return repository.save(M);
    }

    @Override
    public List<Medecin> GetAllMedecins() {
        return repository.findAll();
    }

    @Override
    public void Delete(int id) {
        Medecin M  = repository.findById(id).get() ;
        repository.delete(M);
    }
}
