package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class E2EMarkerTest {

    @Test
    void e2eMarkerFileExistsWithCorrectContent() throws IOException {
        Path marker = Paths.get("e2e-marker.md");
        assertTrue(Files.exists(marker), "e2e-marker.md should exist in project root");
        String content = Files.readString(marker).trim();
        assertEquals("# E2E Test Passed", content, "e2e-marker.md should contain the expected heading");
    }
}
