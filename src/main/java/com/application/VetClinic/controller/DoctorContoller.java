package com.application.VetClinic.controller;

import com.application.VetClinic.dto.DoctorDTO;
import com.application.VetClinic.entity.Doctor;
import com.application.VetClinic.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorContoller {
    @Autowired
    private DoctorService doctorService;

    @GetMapping(value = "/all")
    public List<DoctorDTO> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping(value = "/getById/{doctorId}")
    public DoctorDTO getDoctorById(@PathVariable(value = "doctorId") Long id) {
        return doctorService.getDoctorById(id);
    }

    @PostMapping(value = "/add")
    public Doctor createNewDoctor(@RequestBody Doctor newDoctor) {
        return doctorService.createNewDoctor(newDoctor);
    }

    @GetMapping(value = "/del/{doctorId}")
    public boolean deleteDoctorById(@PathVariable(value = "doctorId") Long id) {
        return doctorService.deleteDoctorById(id);
    }

    @PutMapping(value = "/update/{doctorId}")
    public Doctor updateDoctor(@PathVariable(value = "doctorId") Long id, @RequestBody Doctor newDoctor) {
        return doctorService.updateDoctor(id, newDoctor);
    }







}

