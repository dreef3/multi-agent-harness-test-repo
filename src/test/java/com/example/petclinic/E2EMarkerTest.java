package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class E2EMarkerTest {
    @Test
    void e2eMarkerFileExistsAndHasExpectedContent() throws Exception {
        Path marker = Paths.get("e2e-marker.md");
        assertTrue(Files.exists(marker), "e2e-marker.md should exist at project root");

        List<String> lines = Files.readAllLines(marker);
        assertEquals(1, lines.size(), "e2e-marker.md should contain exactly one line");
        assertEquals("# E2E Test Passed", lines.get(0).trim(), "e2e-marker.md content must match");
    }
}
