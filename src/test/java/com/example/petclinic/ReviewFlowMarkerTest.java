package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReviewFlowMarkerTest {
    @Test
    void reviewFlowMarkerHasExpectedContentWithTrailingNewline() throws Exception {
        Path p = Path.of("review-flow-marker.md");
        String content = Files.readString(p);
        // Expect a trailing newline; this will fail if the file doesn't end with '\n'
        assertEquals("# Review Flow Marker\n", content);
    }
}
