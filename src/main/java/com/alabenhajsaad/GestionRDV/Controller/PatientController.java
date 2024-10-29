package com.alabenhajsaad.GestionRDV.Controller;

import com.alabenhajsaad.GestionRDV.Entities.Patient;
import com.alabenhajsaad.GestionRDV.Services.IService.IServicePatient;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/patient")
public class PatientController {
    private final IServicePatient iServicePatient ;

    @PostMapping("add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Patient AddPatient(@RequestBody Patient p) {
        return iServicePatient.AddPatient(p);
    }

    @GetMapping("all")
    public List<Patient> GetAllPatients() {
        return iServicePatient.GetAllPatients();
    }

    @DeleteMapping("{id}")
    public void Delete(@PathVariable int id) {
        iServicePatient.Delete(id);
    }
}
