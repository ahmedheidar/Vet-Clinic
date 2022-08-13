package com.application.VetClinic.dto;

import com.application.VetClinic.entity.Pet;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OwnerDTO {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private char gender;
    private List<Pet> pets;
}
