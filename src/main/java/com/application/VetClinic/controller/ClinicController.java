package com.application.VetClinic.controller;

import com.application.VetClinic.dto.ClinicDTO;
import com.application.VetClinic.dto.DoctorDTO;
import com.application.VetClinic.dto.VisitDTO;
import com.application.VetClinic.entity.Clinic;
import com.application.VetClinic.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clinic")
public class ClinicController {
    @Autowired
    private ClinicService clinicService;

    @GetMapping(value = "/all")
    public List<ClinicDTO> getAllClinics() {
        return clinicService.getAllClinics();
    }

    @GetMapping(value = "/getById/{clinicId}")
    public ClinicDTO getClinicById(@PathVariable(value = "clinicId") Long id) {
        return clinicService.getClinicById(id);
    }

    @PostMapping(value = "/add")
    public Clinic createNewClinic(@RequestBody Clinic newClinic) {
        return clinicService.createNewClinic(newClinic);
    }

    @DeleteMapping(value = "/del/{clinicId}")
    public boolean deleteClinicById(@PathVariable(value = "clinicId") Long id) {
        return clinicService.deleteClinicById(id);
    }

    @PutMapping(value = "/update/{clinicId}")
    public Clinic updateClinic(@PathVariable(value = "clinicId") Long id, @RequestBody Clinic newClinic) {
        return clinicService.updateClinic(id, newClinic);
    }

    @GetMapping(value = "/listalldoctors/{clinicId}")
    public List<DoctorDTO> getAllDoctors(@PathVariable(value = "clinicId") Long id) {
        return clinicService.getAllDoctorsByClinicId(id);
    }

    @GetMapping(value = "/listallvisits/{clinicId}")
    public List<VisitDTO> getAllVisits(@PathVariable(value = "clinicId") Long id) {
        return clinicService.getAllVisitsByClinicId(id);
    }

}
