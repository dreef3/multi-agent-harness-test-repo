package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReviewFlowMarkerTest {

    @Test
    void reviewFlowMarkerFileContainsExpectedText() throws Exception {
        Path path = Path.of("review-flow-marker.md");
        assertTrue(Files.exists(path), "review-flow-marker.md should exist in project root");
        String content = Files.readString(path, StandardCharsets.UTF_8).trim();
        assertEquals("# Review Flow Marker", content);
    }
}
