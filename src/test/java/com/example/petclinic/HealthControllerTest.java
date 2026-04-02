package com.example.petclinic;

import com.example.petclinic.controller.HealthController;
import com.example.petclinic.service.HealthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HealthController.class)
class HealthControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    HealthService healthService;

    @Test
    void getHealthShouldReturnJson() throws Exception {
        given(healthService.getHealth()).willReturn(Map.of(
                "status", "ok",
                "service", "petclinic",
                "timestamp", "2020-01-01T00:00:00Z"
        ));

        mvc.perform(get("/api/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("ok"))
                .andExpect(jsonPath("$.service").value("petclinic"))
                .andExpect(jsonPath("$.timestamp").exists());
    }
}
