package com.example.petclinic;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Repository interface for Owner entities. Provides CRUD operations and a finder
 * method for looking up owners by last name using Spring Data JPA.
 */
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    List<Owner> findByLastName(String lastName);
}
