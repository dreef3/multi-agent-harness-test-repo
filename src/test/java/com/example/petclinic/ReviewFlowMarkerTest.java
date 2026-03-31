package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReviewFlowMarkerTest {

    @Test
    void reviewFlowMarkerFileExistsWithExactContent() throws IOException {
        Path p = Path.of("review-flow-marker.md");
        String content = Files.readString(p);
        assertEquals("# Review Flow Marker\n", content);
    }
}
