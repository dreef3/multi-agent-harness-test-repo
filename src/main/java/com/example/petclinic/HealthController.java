package com.example.petclinic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collections;
import java.util.Map;

/**
 * Simple health endpoint for basic liveness/health checks.
 */
@RestController
public class HealthController {

    @GetMapping(path = "/health", produces = "application/json")
    public Map<String, String> health() {
        return Collections.singletonMap("status", "ok");
    }
}
