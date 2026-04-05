package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class E2EMarkerTest {

    @Test
    void e2eMarkerFileExistsAndContainsMessage() throws Exception {
        Path p = Paths.get("e2e-marker.md");
        assertTrue(Files.exists(p), "e2e-marker.md should exist");
        String content = new String(Files.readAllBytes(p)).trim();
        assertEquals("# E2E Test Passed", content, "e2e-marker.md should contain the expected message");
    }
}
