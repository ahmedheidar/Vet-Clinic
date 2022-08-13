package com.application.VetClinic.service;

import com.application.VetClinic.dto.ClinicDTO;
import com.application.VetClinic.dto.DoctorDTO;
import com.application.VetClinic.entity.Clinic;
import com.application.VetClinic.entity.Doctor;
import com.application.VetClinic.repository.ClinicRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClinicService {
    @Autowired
    private ClinicRepository clinicRepository;

    public List<ClinicDTO> getAllClinics() {
        List<Clinic> clinics = (List<Clinic>) clinicRepository.findAll();
        List<ClinicDTO> clinicsDTOs = null;

        if (!clinics.isEmpty()) {
            clinicsDTOs = new ArrayList<>();
            ClinicDTO clinicDTO = null;
            for (Clinic clinic : clinics) {
                clinicDTO = new ClinicDTO();
                BeanUtils.copyProperties(clinic, clinicDTO);
                clinicsDTOs.add(clinicDTO);
            }
        }
        return clinicsDTOs;
    }

    public Clinic createNewClinic(Clinic newClinic) {
        if (newClinic != null) {
            return clinicRepository.save(newClinic);
        }
        return null;
    }

    public Boolean deleteClinicById(Long id) {
        if (id != null) {
            clinicRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Clinic updateClinic(Long id, Clinic newClinic) {
        if (id != null && newClinic != null) {
            Clinic clinic = clinicRepository.findById(id).orElse(null);
            BeanUtils.copyProperties(newClinic, clinic);
            return clinicRepository.save(clinic);
        }
        return null;
    }

    public List<Doctor> getAllDoctorsByClinicId(Long id) {
        if (id != null) {
            Clinic clinic = clinicRepository.findById(id).orElse(null);
            assert clinic != null;
            return clinic.getDoctors();
        }
        return null;
    }


}
