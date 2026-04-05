package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

class E2eMarkerTest {

    @Test
    void e2eMarkerFileExists() {
        Path marker = Path.of("e2e-marker.md");
        assertTrue(Files.exists(marker), "e2e-marker.md should exist in the repository root");
    }
}
