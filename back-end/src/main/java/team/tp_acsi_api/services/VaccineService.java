package team.tp_acsi_api.services;

import team.tp_acsi_api.models.Vaccine;
import team.tp_acsi_api.repositories.VaccineRepository;
import team.tp_acsi_api.requests.VaccineRequest;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VaccineService {
    private final VaccineRepository vaccineRepository;

    @Autowired
    public VaccineService(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    public Vaccine createVaccine(String userId, String name, Date date) {

        Vaccine vaccine = new Vaccine();
        vaccine.setUserId(userId);
        vaccine.setName(name);
        vaccine.setDate(date);

        this.vaccineRepository.save(vaccine);

        return vaccine;
    }

    public List<Vaccine> getAllVaccines(String userId) {
        return vaccineRepository.findByUserId(userId);
    }
}