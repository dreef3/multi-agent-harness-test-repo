package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class E2EMarkerTest {
    @Test
    void e2eMarkerFileExistsAndHasExactContent() throws Exception {
        Path p = Path.of("e2e-marker.md");
        assertTrue(Files.exists(p), "e2e-marker.md should exist at repository root");
        String content = Files.readString(p, StandardCharsets.UTF_8);
        assertEquals("# E2E Test Passed\n", content, "e2e-marker.md must contain exactly '# E2E Test Passed' followed by a newline");
    }
}
