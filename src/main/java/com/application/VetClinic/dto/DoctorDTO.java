package com.application.VetClinic.dto;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DoctorDTO {
    private Long id;
    private String name;
    private String photoUrl;
    private String biography;
    private ClinicDTO clinic;
}

