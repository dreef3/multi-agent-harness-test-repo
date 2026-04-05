package com.example;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

public class ReviewFlowMarkerTest {

    @Test
    public void markerFileExistsAndHasExpectedContent() throws Exception {
        Path p = Path.of("review-flow-marker.md");
        assertTrue(Files.exists(p), "review-flow-marker.md should exist in repo root");
        String content = Files.readString(p);
        assertEquals("# Review Flow Marker\n", content, "File content should be '# Review Flow Marker' followed by newline");
    }
}
