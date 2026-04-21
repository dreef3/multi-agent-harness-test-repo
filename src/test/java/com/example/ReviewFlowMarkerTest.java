package com.example;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReviewFlowMarkerTest {

    @Test
    public void reviewFlowMarkerFileExistsAndHasCorrectContent() throws Exception {
        Path path = Path.of("review-flow-marker.md");
        String content = Files.readString(path).trim();
        assertEquals("# Review Flow Marker", content);
    }
}
