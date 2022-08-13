package com.application.VetClinic.controller;

import com.application.VetClinic.dto.OwnerDTO;
import com.application.VetClinic.entity.Owner;
import com.application.VetClinic.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping(value = "/all")
    public List<OwnerDTO> getAllOwners() {
        return ownerService.getAllOwners();
    }

    @GetMapping(value = "/getById/{ownerId}")
    public OwnerDTO getOwnerById(@PathVariable(value = "ownerId") Long id) {
        return ownerService.getOwnerById(id);
    }

    @PostMapping(value = "/add")
    public Owner createNewOwner(@RequestBody Owner newOwner) {
        return ownerService.createNewOwner(newOwner);
    }

    @GetMapping(value = "/del/{ownerId}")
    public boolean deleteOwnerById(@PathVariable(value = "ownerId") Long id) {
        return ownerService.deleteOwnerById(id);
    }

    @PutMapping(value = "/update/{ownerId}")
    public Owner updateOwner(@PathVariable(value = "ownerId") Long id, @RequestBody Owner newOwner) {
        return ownerService.updateOwner(id, newOwner);
    }
}
