package com.application.VetClinic.service;

import com.application.VetClinic.dto.ClinicDTO;
import com.application.VetClinic.dto.DoctorDTO;
import com.application.VetClinic.dto.VisitDTO;
import com.application.VetClinic.entity.Clinic;
import com.application.VetClinic.entity.Doctor;
import com.application.VetClinic.entity.Visit;
import com.application.VetClinic.repository.ClinicRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ClinicService {
    @Autowired
    private ClinicRepository clinicRepository;

    public List<ClinicDTO> getAllClinics() {
        List<Clinic> clinics = (List<Clinic>) clinicRepository.findAll();
        List<ClinicDTO> clinicsDTOs = null;

        if (!clinics.isEmpty()) {
            clinicsDTOs = new ArrayList<>();
            ClinicDTO clinicDTO;
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
            assert clinic != null;
            BeanUtils.copyProperties(newClinic, clinic);
            return clinicRepository.save(clinic);
        }
        return null;
    }

    public List<DoctorDTO> getAllDoctorsByClinicId(Long id) {
        List<Doctor> doctors = Objects.requireNonNull(clinicRepository.findById(id).orElse(null)).getDoctors();
        List<DoctorDTO> doctorsDTOs = null;

        if (!doctors.isEmpty()) {
            doctorsDTOs = new ArrayList<>();
            DoctorDTO doctorDTO;
            for (Doctor doctor : doctors) {
                doctorDTO = new DoctorDTO();
                BeanUtils.copyProperties(doctor, doctorDTO);
                doctorsDTOs.add(doctorDTO);
            }
        }
        return doctorsDTOs;
    }


    public ClinicDTO getClinicById(Long id) {
        Clinic clinic = clinicRepository.findById(id).orElse(null);
        ClinicDTO clinicDTO = null;
        if (clinic != null) {
            clinicDTO = new ClinicDTO();
            BeanUtils.copyProperties(clinic, clinicDTO);
        }
        return clinicDTO;
    }

    public List<VisitDTO> getAllVisitsByClinicId(Long id) {
        List<VisitDTO> visitsDTOs = null;
        List<Visit> visits = Objects.requireNonNull(clinicRepository.findById(id).orElse(null)).getVisits();
        if (!visits.isEmpty()) {
            visitsDTOs = new ArrayList<>();
            VisitDTO visitDTO;
            for (Visit visit : visits) {
                visitDTO = new VisitDTO();
                BeanUtils.copyProperties(visit, visitDTO);
                visitsDTOs.add(visitDTO);
            }
        }
        return visitsDTOs;
    }
}
