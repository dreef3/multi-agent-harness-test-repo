package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReviewFlowMarkerTest {

    @Test
    void reviewFlowMarkerFileHasExpectedContent() throws Exception {
        Path p = Path.of("review-flow-marker.md");
        String content = Files.readString(p);
        assertEquals("# Review Flow Marker\n\n<!-- E2E test marker -->\n", content);
    }
}
