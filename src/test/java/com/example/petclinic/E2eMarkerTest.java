package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class E2eMarkerTest {

    @Test
    void e2eMarkerFileExistsWithCorrectContent() throws IOException {
        Path p = Path.of("e2e-marker.md");
        assertTrue(Files.exists(p), "e2e-marker.md should exist at repository root");
        String content = Files.readString(p).trim();
        assertEquals("# E2E Test Passed", content, "e2e-marker.md must contain the exact marker text");
    }
}
