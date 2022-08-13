package com.application.VetClinic.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "photo_url", length = 100)
    private String photoUrl;

    @Column(name = "biography", length = 100)
    private String biography;

    @JoinColumn(name = "clinic_id")
    @ManyToOne
    private Clinic clinic;

}
