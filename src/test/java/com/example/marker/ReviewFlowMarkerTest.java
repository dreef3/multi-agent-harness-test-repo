package com.example.marker;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ReviewFlowMarkerTest {

    @Test
    void markerPresent() throws Exception {
        String content = Files.readString(Path.of("review-flow-marker.md"));
        assertTrue(content.contains("<!-- E2E test marker -->"), "Marker not found in review-flow-marker.md");
    }
}
