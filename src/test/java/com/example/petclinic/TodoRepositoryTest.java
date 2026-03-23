package com.example.petclinic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    void shouldSaveAndFindTodo() {
        Todo todo = new Todo("Test task", "Test description");
        Todo saved = todoRepository.save(todo);
        
        assertNotNull(saved.getId());
        assertEquals("Test task", saved.getTitle());
    }

    @Test
    void shouldFindByCompleted() {
        Todo completed = new Todo("Done", "Done task", true);
        Todo pending = new Todo("Not done", "Pending task", false);
        
        todoRepository.save(completed);
        todoRepository.save(pending);
        
        List<Todo> pendingTodos = todoRepository.findByCompleted(false);
        assertEquals(1, pendingTodos.size());
        assertEquals("Not done", pendingTodos.get(0).getTitle());
    }

    @Test
    void shouldFindByTitleContaining() {
        Todo todo1 = new Todo("Buy groceries", "Description 1");
        Todo todo2 = new Todo("Buy supplies", "Description 2");
        Todo todo3 = new Todo("Walk dog", "Description 3");
        
        todoRepository.save(todo1);
        todoRepository.save(todo2);
        todoRepository.save(todo3);
        
        List<Todo> results = todoRepository.findByTitleContaining("Buy");
        assertEquals(2, results.size());
    }
}
