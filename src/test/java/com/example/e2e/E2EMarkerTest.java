package com.example.e2e;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class E2EMarkerTest {

    @Test
    void e2eMarkerFileMustExist() {
        // This test asserts that a file named e2e-marker.md exists at project root
        assertTrue(Files.exists(Path.of("e2e-marker.md")), "e2e-marker.md should exist in project root");
    }
}
