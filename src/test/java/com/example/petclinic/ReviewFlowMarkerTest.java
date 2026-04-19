package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReviewFlowMarkerTest {

    @Test
    void reviewFlowMarkerFileExistsWithExpectedContent() throws IOException {
        Path path = Path.of("review-flow-marker.md");
        assertTrue(Files.exists(path), "review-flow-marker.md should exist in project root");
        String content = Files.readString(path);
        assertEquals("# Review Flow Marker\n", content, "File content should match exactly");
    }
}
