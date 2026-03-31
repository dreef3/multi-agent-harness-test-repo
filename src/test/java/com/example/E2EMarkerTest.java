package com.example;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class E2EMarkerTest {

    @Test
    void e2eMarkerFileShouldExistWithCorrectContent() throws Exception {
        Path path = Paths.get("e2e-marker.md");
        assertTrue(Files.exists(path), "e2e-marker.md should exist in the project root");
        String content = Files.readString(path).trim();
        assertEquals("# E2E Test Passed", content, "e2e-marker.md should contain the exact marker text");
    }
}
