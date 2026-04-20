package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ReviewFlowMarkerTest {
    @Test
    void reviewFlowMarkerIsPresent() throws Exception {
        String content = Files.readString(Path.of("review-flow-marker.md"));
        assertTrue(content.contains("<!-- E2E test marker -->"), "review-flow-marker.md must contain the E2E test marker");
    }
}
