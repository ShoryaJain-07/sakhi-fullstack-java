package team.tp_acsi_api.controllers;

import team.tp_acsi_api.models.Vaccine;
import team.tp_acsi_api.requests.VaccineRequest;
import team.tp_acsi_api.services.VaccineService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/vaccine")
public class VaccineController {
    private final VaccineService vaccineService;

    @Autowired
    public VaccineController(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @PostMapping
    public ResponseEntity<Vaccine> createVaccine(@RequestBody VaccineRequest vaccine) {
        String userId = vaccine.getUserId();
        String name = vaccine.getName();
        Date date = vaccine.getDate();
        Vaccine savedVaccine = vaccineService.createVaccine(userId, name, date);
        return new ResponseEntity<>(savedVaccine, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Vaccine>> getAllVaccines(@RequestParam String userId) {
        List<Vaccine> vaccines = vaccineService.getAllVaccines(userId);
        return new ResponseEntity<>(vaccines, HttpStatus.OK);
    }
}