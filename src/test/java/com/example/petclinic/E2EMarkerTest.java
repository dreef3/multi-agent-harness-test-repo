package com.example.petclinic;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class E2EMarkerTest {
    @Test
    void e2eMarkerFileExistsAndHasExpectedContent() throws Exception {
        Path p = Path.of("e2e-marker.md");
        assertTrue(Files.exists(p), "e2e-marker.md should exist in the project root");
        String content = Files.readString(p);
        assertEquals("# E2E Test Passed", content.trim());
    }
}
