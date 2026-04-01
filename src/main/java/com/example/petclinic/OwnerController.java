package com.example.petclinic;

import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST controller exposing CRUD operations for Owner entities.
 */
@RestController
@RequestMapping("/owners")
public class OwnerController {
    private final OwnerRepository ownerRepository;

    public OwnerController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @GetMapping
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Owner getOwnerById(@PathVariable Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    /**
     * Search owners by last name.
     * Example: GET /owners/search?lastName=Doe
     */
    @GetMapping("/search")
    public List<Owner> searchOwnersByLastName(@RequestParam String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @PostMapping
    public Owner createOwner(@RequestBody Owner owner) {
        return ownerRepository.save(owner);
    }
}
