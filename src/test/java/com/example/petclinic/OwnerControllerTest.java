package com.example.petclinic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Unit tests for OwnerController. Uses MockMvc to verify controller behaviour.
 */
@WebMvcTest(OwnerController.class)
class OwnerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OwnerRepository ownerRepository;

    @Test
    @DisplayName("GET /owners/search returns owners by last name")
    void testSearchOwnersByLastName() throws Exception {
        Owner owner = new Owner("John", "Doe", "123 Main St", "Townsville", "555-1234");
        owner.setId(1L);

        when(ownerRepository.findByLastName("Doe")).thenReturn(Collections.singletonList(owner));

        mockMvc.perform(get("/owners/search?lastName=Doe"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id':1,'firstName':'John','lastName':'Doe','address':'123 Main St','city':'Townsville','telephone':'555-1234'}]"));
    }
}
