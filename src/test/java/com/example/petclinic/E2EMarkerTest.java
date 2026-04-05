package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class E2EMarkerTest {

    @Test
    void e2eMarkerFileExistsWithContent() throws IOException {
        Path marker = Path.of("e2e-marker.md");
        assertTrue(Files.exists(marker), "e2e-marker.md should exist in project root");

        String content = Files.readString(marker, StandardCharsets.UTF_8).trim();
        assertEquals("# E2E Test Passed", content, "e2e-marker.md should contain the expected header");
    }
}
