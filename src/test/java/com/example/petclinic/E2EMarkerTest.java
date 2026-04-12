package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class E2EMarkerTest {

    @Test
    void e2eMarkerFileExists() {
        Path marker = Paths.get("e2e-marker.md");
        assertTrue(Files.exists(marker), "e2e-marker.md should exist in the project root");
    }
}
