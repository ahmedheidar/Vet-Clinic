package com.application.VetClinic.repository;

import com.application.VetClinic.entity.Clinic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicRepository extends CrudRepository<Clinic, Long> {


}
