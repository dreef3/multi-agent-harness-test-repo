package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class E2EMarkerTest {
    @Test
    void e2eMarkerFileExistsWithContent() throws Exception {
        Path p = Paths.get("e2e-marker.md");
        assertTrue(Files.exists(p), "e2e-marker.md must exist in project root");
        String content = Files.readString(p);
        assertEquals("# E2E Test Passed", content.trim(), "e2e-marker.md must contain the exact marker text");
    }
}
