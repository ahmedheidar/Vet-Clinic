package com.application.VetClinic.service;

import com.application.VetClinic.dto.DoctorDTO;
import com.application.VetClinic.entity.Doctor;
import com.application.VetClinic.repository.DoctorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<DoctorDTO> getAllDoctors() {
        List<Doctor> doctors = (List<Doctor>) doctorRepository.findAll();
        List<DoctorDTO> doctorsDTOs = null;

        if(!doctors.isEmpty()){
            doctorsDTOs = new ArrayList<>();
            DoctorDTO doctorDTO = null;
            for (Doctor doctor:doctors) {
                doctorDTO = new DoctorDTO();
                BeanUtils.copyProperties(doctor,doctorDTO);
                doctorsDTOs.add(doctorDTO);
            }
        }
        return doctorsDTOs;
    }

    public Doctor createNewDoctor(Doctor newDoctor) {
        if(newDoctor != null){
            return doctorRepository.save(newDoctor);
        }
        return null;
    }

    public Boolean deleteDoctorById(Long id) {
        if(id != null){
            doctorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Doctor updateDoctor(Long id, Doctor newDoctor) {
        if(id != null && newDoctor != null){
            Doctor doctor = doctorRepository.findById(id).orElse(null);
            BeanUtils.copyProperties(newDoctor,doctor);
            return doctorRepository.save(doctor);
        }
        return null;
    }


}
