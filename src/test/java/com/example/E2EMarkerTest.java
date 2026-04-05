package com.example;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

public class E2EMarkerTest {

    @Test
    void e2eMarkerFileExistsAndContainsMessage() throws Exception {
        Path p = Path.of("e2e-marker.md");
        assertTrue(Files.exists(p), "e2e-marker.md should exist");
        String content = Files.readString(p, StandardCharsets.UTF_8).trim();
        assertEquals("# E2E Test Passed", content, "e2e-marker.md must contain the expected message");
    }
}
