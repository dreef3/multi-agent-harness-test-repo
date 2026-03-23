package com.example.petclinic;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class TodoTest {

    @Test
    void shouldCreateTodoWithTitleAndDescription() {
        Todo todo = new Todo("Buy groceries", "Get milk and bread");
        
        assertEquals("Buy groceries", todo.getTitle());
        assertEquals("Get milk and bread", todo.getDescription());
        assertFalse(todo.isCompleted());
    }

    @Test
    void shouldCreateCompletedTodo() {
        Todo todo = new Todo("Completed task", "This is done", true);
        
        assertTrue(todo.isCompleted());
    }

    @Test
    void shouldSetCompletedStatus() {
        Todo todo = new Todo("Test task", "Description");
        assertFalse(todo.isCompleted());
        
        todo.setCompleted(true);
        assertTrue(todo.isCompleted());
    }

    @Test
    void shouldSetTitleAndDescription() {
        Todo todo = new Todo();
        todo.setTitle("New title");
        todo.setDescription("New description");
        
        assertEquals("New title", todo.getTitle());
        assertEquals("New description", todo.getDescription());
    }

    @Test
    void shouldHaveTimestamps() {
        Todo todo = new Todo("Task", "Description");
        
        assertNotNull(todo.getCreatedAt());
        assertNotNull(todo.getUpdatedAt());
    }

    @Test
    void shouldSetId() {
        Todo todo = new Todo("Task", "Description");
        todo.setId(1L);
        
        assertEquals(1L, todo.getId());
    }
}
