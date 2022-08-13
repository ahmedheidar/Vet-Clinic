package com.application.VetClinic.controller;

import com.application.VetClinic.dto.PetDTO;
import com.application.VetClinic.entity.Pet;
import com.application.VetClinic.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService petService;

    @GetMapping(value = "/all")
    public List<PetDTO> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping(value = "/getById/{petId}")
    public PetDTO getPetById(@PathVariable(value = "petId") Long id) {
        return petService.getPetById(id);
    }

    @PostMapping(value = "/add")
    public Pet createNewPet(@RequestBody Pet newPet) {
        return petService.createNewPet(newPet);
    }

    @GetMapping(value = "/del/{petId}")
    public boolean deletePetById(@PathVariable(value = "petId") Long id) {
        return petService.deletePetById(id);
    }

    @PutMapping(value = "/update/{petId}")
    public Pet updatePet(@PathVariable(value = "petId") Long id, @RequestBody Pet newPet) {
        return petService.updatePet(id, newPet);
    }

}
