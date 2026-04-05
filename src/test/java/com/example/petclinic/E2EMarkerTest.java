package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class E2EMarkerTest {
    @Test
    void e2eMarkerFileExistsWithExpectedContent() {
        Path p = Path.of("e2e-marker.md");
        if (!Files.exists(p)) {
            fail("e2e-marker.md is missing");
        }
        try {
            String content = Files.readString(p);
            assertTrue(content.contains("# E2E Test Passed"), "e2e-marker.md does not contain expected marker");
        } catch (IOException e) {
            fail("Failed to read e2e-marker.md: " + e.getMessage());
        }
    }
}
