package com.example.petclinic;

import com.example.petclinic.service.HealthService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HealthServiceTest {

    @Test
    void shouldReturnHealthMapContainingStatusServiceAndTimestamp() {
        HealthService service = new HealthService();
        var map = service.getHealth();
        assertNotNull(map);
        assertEquals("ok", map.get("status"));
        assertEquals("petclinic", map.get("service"));
        assertTrue(map.containsKey("timestamp"));
        assertNotNull(map.get("timestamp"));
    }
}
