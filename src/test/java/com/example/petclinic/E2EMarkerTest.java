package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

class E2EMarkerTest {
    @Test
    void e2eMarkerFileExists() {
        Path p = Path.of("e2e-marker_1776751127.md");
        assertTrue(Files.exists(p), "Expected file e2e-marker_1776751127.md to exist at repo root");
    }
}
