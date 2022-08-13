package com.application.VetClinic.dto;

import com.application.VetClinic.entity.Doctor;

import java.util.List;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClinicDTO {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private List<Doctor> doctors;
    private String workingHours;
    private String socialMediaUrls;
}
