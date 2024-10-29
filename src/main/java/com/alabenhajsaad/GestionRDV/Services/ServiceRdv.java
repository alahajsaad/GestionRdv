package com.alabenhajsaad.GestionRDV.Services;

import com.alabenhajsaad.GestionRDV.Entities.Rdv;
import com.alabenhajsaad.GestionRDV.Repositories.RdvRepository;
import com.alabenhajsaad.GestionRDV.Services.IService.IServiceRdv;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceRdv implements IServiceRdv {
    private final RdvRepository repository ;

    @Override
    public Object AddRdv(Rdv rdv) {
        LocalDateTime date = rdv.getDateRdv();

        // Check if the patient already has an appointment at the same time
        Rdv patientRdv = repository.findByPatientIdAndDateRdv(rdv.getPatient().getId(), date);
        if (patientRdv != null) {
            return "Patient is not available at this time";
        }

        // Check if the doctor already has an appointment at the same time
        Rdv medecinRdv = repository.findByMedecinIdAndDateRdv(rdv.getMedecin().getId(), date);
        if (medecinRdv != null) {
            return "Doctor is not available at this time";
        }

        // Save the appointment if there are no conflicts
        return repository.save(rdv);
    }


    @Override
    public List<Rdv> GetAllRDV() {
        return repository.findAll();
    }

    public List<Rdv> findAppointmentsByDate(LocalDate date) {
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(LocalTime.MAX);

        return repository.findByDateRdvBetween(startOfDay, endOfDay);
    }
}