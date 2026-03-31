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
        // The marker file includes an HTML comment explaining its purpose followed by a header.
        assertEquals("<!-- Marker file used by automated review flow tests. Do not modify. -->\n# Review Flow Marker\n", content);
    }
}
