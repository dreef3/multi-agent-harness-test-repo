package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class E2EMarkerTest {

    @Test
    void e2eMarkerFileExistsWithCorrectContent() throws Exception {
        Path p = Paths.get("e2e-marker.md");
        assertTrue(Files.exists(p), "e2e-marker.md should exist in repository root");
        String content = Files.readString(p).trim();
        assertEquals("# E2E Test Passed", content, "e2e-marker.md should contain the exact marker line");
    }
}
