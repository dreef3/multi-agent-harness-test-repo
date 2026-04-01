package com.example.petclinic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

class E2EMarkerTest {
    @Test
    void e2eMarkerFileExistsWithCorrectContent() throws IOException {
        Path p = Paths.get("e2e-marker.md");
        Assertions.assertTrue(Files.exists(p), "e2e-marker.md should exist at repository root");
        String content = Files.readString(p).trim();
        Assertions.assertEquals("# E2E Test Passed", content, "e2e-marker.md should contain the expected marker");
    }
}
