package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ReviewFlowMarkerTest {
    @Test
    void reviewFlowMarkerIsPresent() throws Exception {
        Path p = Path.of("review-flow-marker.md");
        String content = Files.readString(p, StandardCharsets.UTF_8);
        assertTrue(content.contains("<!-- E2E test marker -->"), "review-flow-marker.md should contain the E2E test marker");
    }
}
