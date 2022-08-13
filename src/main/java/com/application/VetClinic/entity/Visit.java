package com.application.VetClinic.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "visit")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", length = 100, nullable = false)
    private String date;

    @JoinColumn(name = "pet_id")
    @ManyToOne
    private Pet pet;

    @JoinColumn(name = "doctor_id")
    @ManyToOne
    private Doctor doctor;

    @JoinColumn(name = "clinic_id")
    @ManyToOne
    private Clinic clinic;

}
