package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class E2EMarkerTest {

    @Test
    void e2eMarkerFileExists() {
        Path p = Paths.get("e2e-marker.md");
        assertTrue(Files.exists(p), "e2e-marker.md must exist in repository root");
    }
}
