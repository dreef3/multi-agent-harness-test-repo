package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class E2EMarkerTest {
    @Test
    void e2eMarkerFileExistsAndHasExpectedContent() throws Exception {
        Path p = Path.of("e2e-marker.md");
        assertTrue(Files.exists(p), "e2e-marker.md should exist in project root");
        String content = Files.readString(p, StandardCharsets.UTF_8).trim();
        assertEquals("# E2E Test Passed", content, "e2e-marker.md should contain the expected marker");
    }
}
