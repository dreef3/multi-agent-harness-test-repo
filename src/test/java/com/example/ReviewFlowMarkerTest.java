package com.example;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReviewFlowMarkerTest {

    @Test
    public void markerIsPresentAtEndOfFile() throws Exception {
        Path p = Path.of("review-flow-marker.md");
        String content = Files.readString(p);
        assertTrue(content.endsWith("<!-- E2E test marker -->\n") || content.endsWith("<!-- E2E test marker -->"), "review-flow-marker.md must end with the E2E test marker");
    }
}
