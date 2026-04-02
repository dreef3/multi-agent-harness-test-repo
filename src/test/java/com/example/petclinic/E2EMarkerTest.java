package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class E2EMarkerTest {

    @Test
    void e2eMarkerFileExistsWithCorrectContent() throws Exception {
        Path path = Paths.get("e2e-marker.md");
        assertTrue(Files.exists(path), "e2e-marker.md should exist in project root");
        String content = Files.readString(path);
        assertEquals("# E2E Test Passed", content.trim(), "e2e-marker.md should contain the expected marker text");
    }
}
