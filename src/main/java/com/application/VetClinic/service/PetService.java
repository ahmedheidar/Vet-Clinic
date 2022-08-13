package com.application.VetClinic.service;

import com.application.VetClinic.dto.PetDTO;
import com.application.VetClinic.entity.Pet;
import com.application.VetClinic.repository.PetRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    public List<PetDTO> getAllPets() {
        List<Pet> pets = (List<Pet>) petRepository.findAll();
        List<PetDTO> petsDTOs = null;

        if (!pets.isEmpty()) {
            petsDTOs = new ArrayList<>();
            PetDTO petDTO;
            for (Pet pet : pets) {
                petDTO = new PetDTO();
                BeanUtils.copyProperties(pet, petDTO);
                petsDTOs.add(petDTO);
            }
        }
        return petsDTOs;
    }

    public Pet createNewPet(Pet newPet) {
        if(newPet != null){
            return petRepository.save(newPet);
        }
        return null;
    }


    public Boolean deletePetById(Long id) {
        if(id != null){
            petRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Pet updatePet(Long id, Pet newPet) {
        if(id != null && newPet != null){
            Pet pet = petRepository.findById(id).orElse(null);
            assert pet != null;
            BeanUtils.copyProperties(newPet,pet);
            return petRepository.save(pet);
        }
        return null;
    }


}
