package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReviewFlowMarkerTest {
    @Test
    void reviewFlowMarkerHasTrailingNewline() throws IOException {
        String content = Files.readString(Path.of("review-flow-marker.md"));
        // Expect the file to end with a newline
        assertEquals("# Review Flow Marker\n", content);
    }
}
