package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class E2EMarkerTest {
    @Test
    void reviewFlowMarkerContainsE2EMarker() throws Exception {
        Path p = Path.of("review-flow-marker.md");
        List<String> lines = Files.readAllLines(p, StandardCharsets.UTF_8);
        // Ensure file ends with the exact marker line
        String last = lines.isEmpty() ? "" : lines.get(lines.size() - 1);
        assertEquals("<!-- E2E test marker -->", last);
    }
}
