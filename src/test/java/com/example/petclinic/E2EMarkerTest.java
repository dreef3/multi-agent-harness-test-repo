package com.example.petclinic;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class E2EMarkerTest {
    @Test
    void e2eMarkerFileExistsWithCorrectContent() throws Exception {
        Path marker = Path.of("e2e-marker.md");
        assertTrue(Files.exists(marker), "e2e-marker.md should exist at the repository root");
        String content = Files.readString(marker).trim();
        assertEquals("# E2E Test Passed", content, "e2e-marker.md content should match");
    }
}
