package com.application.VetClinic.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name="weight")
    private double weight;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "animal_kind", length = 100, nullable = false)
    private String animalKind;

    @Column(name = "gender")
    private char gender;

    @Column(name = "photo_url", length = 100)
    private String photoUrl;

    @JoinColumn(name = "owner_id")
    @ManyToOne
    private Owner owner;

    @OneToMany(mappedBy = "pet")
    private List<Visit> visits;


}
