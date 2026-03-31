package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class E2EMarkerTest {

    @Test
    void e2eMarkerFileExistsWithCorrectContent() throws Exception {
        Path p = Paths.get("e2e-marker.md");
        // First assert file exists (this will fail until the file is created)
        assertTrue(Files.exists(p), "e2e-marker.md must exist in project root");
        String content = Files.readString(p).trim();
        assertEquals("# E2E Test Passed", content, "e2e-marker.md must contain the exact marker text");
    }
}
