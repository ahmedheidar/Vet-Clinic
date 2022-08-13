package com.application.VetClinic.dto;

import com.application.VetClinic.entity.Owner;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PetDTO {
    private Long id;
    private String name;
    private double weight;
    private String dateOfBirth;
    private String animalKind;
    private char gender;
    private String photoUrl;
    private Owner owner;


}
