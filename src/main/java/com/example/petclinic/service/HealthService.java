package com.example.petclinic.service;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class HealthService {

    public Map<String, String> getHealth() {
        Map<String, String> m = new LinkedHashMap<>();
        m.put("status", "ok");
        m.put("service", "petclinic");
        m.put("timestamp", Instant.now().toString());
        return m;
    }
}
