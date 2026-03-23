package com.example.petclinic;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Repository interface for Todo entity operations.
 */
public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByCompleted(boolean completed);
}
