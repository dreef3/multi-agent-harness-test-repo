package com.example.petclinic;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class E2eMarkerTest {
    @Test
    void e2eMarkerFileExistsWithCorrectContent() throws Exception {
        Path p = Path.of("e2e-marker.md");
        assertTrue(Files.exists(p), "e2e-marker.md should exist");
        String content = Files.readString(p).trim();
        assertEquals("# E2E Test Passed", content, "e2e-marker.md should contain the expected text");
    }
}
