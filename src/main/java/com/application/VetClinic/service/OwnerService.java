package com.application.VetClinic.service;

import com.application.VetClinic.dto.OwnerDTO;
import com.application.VetClinic.entity.Owner;
import com.application.VetClinic.entity.Pet;
import com.application.VetClinic.repository.OwnerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    public List<OwnerDTO> getAllOwners() {
        List<Owner> owners = (List<Owner>) ownerRepository.findAll();
        List<OwnerDTO> ownersDTOs = null;

        if(!owners.isEmpty()){
            ownersDTOs = new ArrayList<>();
            OwnerDTO ownerDTO = null;
            for (Owner owner:owners) {
                ownerDTO = new OwnerDTO();
                BeanUtils.copyProperties(owner,ownerDTO);
                ownersDTOs.add(ownerDTO);
            }
        }
        return ownersDTOs;
    }

    public Owner createNewOwner(Owner newOwner) {
        if(newOwner != null){
            return ownerRepository.save(newOwner);
        }
        return null;
    }

    public List<Pet> getAllPetsByOwnerId(Long id) {
        return Objects.requireNonNull(ownerRepository.findById(id).orElse(null)).getPets();
    }

    public Boolean deleteOwnerById(Long id) {
        if(id != null){
            ownerRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public Owner updateOwner(Long id, Owner newOwner) {
        if(id != null && newOwner != null){
            Owner owner = ownerRepository.findById(id).orElse(null);
            BeanUtils.copyProperties(newOwner,owner);
            return ownerRepository.save(owner);
        }
        return null;
    }
}
