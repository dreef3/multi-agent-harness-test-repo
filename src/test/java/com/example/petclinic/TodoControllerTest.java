package com.example.petclinic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Tests for Todo CRUD endpoints.
 */
@WebMvcTest(TodoController.class)
class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoRepository todoRepository;

    @Test
    void testGetAllTodos() throws Exception {
        Todo todo1 = new Todo("Todo 1", "Description 1", false);
        todo1.setId(1L);
        Todo todo2 = new Todo("Todo 2", "Description 2", true);
        todo2.setId(2L);

        when(todoRepository.findAll()).thenReturn(Arrays.asList(todo1, todo2));

        mockMvc.perform(get("/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Todo 1"))
                .andExpect(jsonPath("$[1].title").value("Todo 2"));
    }

    @Test
    void testGetTodoById_Found() throws Exception {
        Todo todo = new Todo("Test Todo", "Test Description", false);
        todo.setId(1L);

        when(todoRepository.findById(1L)).thenReturn(Optional.of(todo));

        mockMvc.perform(get("/todos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test Todo"));
    }

    @Test
    void testGetTodoById_NotFound() throws Exception {
        when(todoRepository.findById(99L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/todos/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreateTodo() throws Exception {
        String json = "{\"title\":\"Test Todo\",\"description\":\"Test Description\",\"completed\":false}";
        
        Todo savedTodo = new Todo("Test Todo", "Test Description", false);
        savedTodo.setId(1L);
        
        when(todoRepository.save(any(Todo.class))).thenReturn(savedTodo);

        mockMvc.perform(post("/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Test Todo"))
                .andExpect(jsonPath("$.completed").value(false));
    }

    @Test
    void testUpdateTodo_Found() throws Exception {
        Todo existingTodo = new Todo("Old Title", "Old Description", false);
        existingTodo.setId(1L);

        Todo updatedTodo = new Todo("Updated Todo", "Updated Description", true);
        updatedTodo.setId(1L);

        when(todoRepository.findById(1L)).thenReturn(Optional.of(existingTodo));
        when(todoRepository.save(any(Todo.class))).thenReturn(updatedTodo);

        String json = "{\"title\":\"Updated Todo\",\"description\":\"Updated Description\",\"completed\":true}";
        
        mockMvc.perform(put("/todos/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated Todo"))
                .andExpect(jsonPath("$.completed").value(true));
    }

    @Test
    void testUpdateTodo_NotFound() throws Exception {
        when(todoRepository.findById(99L)).thenReturn(Optional.empty());

        String json = "{\"title\":\"Updated Todo\",\"description\":\"Updated Description\",\"completed\":true}";
        
        mockMvc.perform(put("/todos/99")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDeleteTodo_Found() throws Exception {
        when(todoRepository.existsById(1L)).thenReturn(true);

        mockMvc.perform(delete("/todos/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void testDeleteTodo_NotFound() throws Exception {
        when(todoRepository.existsById(99L)).thenReturn(false);

        mockMvc.perform(delete("/todos/99"))
                .andExpect(status().isNotFound());
    }
}
