package com.application.VetClinic.dto;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VisitDTO {
    private Long id;
    private String date;
    private String time;
    private String description;
    private DoctorDTO doctor;
    private PetDTO pet;

}
