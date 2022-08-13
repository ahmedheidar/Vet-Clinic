package com.application.VetClinic.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "clinic")
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "phone", length = 100)
    private String phone;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "working_hours", length = 100)
    private String workingHours;

    @Column(name = "social_media_urls", length = 100)
    private String socialMediaUrls;

    @OneToMany(mappedBy = "clinic")
    private List<Doctor> doctors;


}
