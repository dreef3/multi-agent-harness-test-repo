package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ReviewFlowMarkerTest {

    @Test
    void reviewFlowMarkerFileExistsWithCorrectContent() throws IOException {
        Path path = Path.of("review-flow-marker.md");
        assertTrue(Files.exists(path), "review-flow-marker.md should exist in repository root");
        String content = Files.readString(path).trim();
        assertEquals("# Review Flow Marker", content, "review-flow-marker.md should contain the exact marker header");
    }
}
