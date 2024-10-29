package com.alabenhajsaad.GestionRDV.Controller;

import com.alabenhajsaad.GestionRDV.Entities.Medecin;
import com.alabenhajsaad.GestionRDV.Services.IService.IServiceMedecin;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/medecin")
public class MedecinController{
    private final IServiceMedecin iServiceMedecin ;

    @PostMapping("add")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    public Medecin AddMedecin(@RequestBody Medecin M) {
        return iServiceMedecin.AddMedecin(M);
    }

    @GetMapping("all")
    public List<Medecin> GetAllMedecins() {
        return iServiceMedecin.GetAllMedecins();
    }

    @DeleteMapping("{id}")
    public void Delete(@PathVariable int id) {
        iServiceMedecin.Delete(id);
    }
}