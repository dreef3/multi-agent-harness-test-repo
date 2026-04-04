package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReviewFlowMarkerTest {
    @Test
    void reviewFlowMarkerFileExistsWithCorrectContent() throws IOException {
        Path p = Path.of("review-flow-marker.md");
        assertTrue(Files.exists(p), "review-flow-marker.md should exist in project root");
        List<String> lines = Files.readAllLines(p);
        assertFalse(lines.isEmpty());
        assertEquals("# Review Flow Marker", lines.get(0));
    }
}
