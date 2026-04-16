package com.example;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

public class ReviewFlowMarkerTest {

    @Test
    void reviewFlowMarkerHasExpectedContent() throws Exception {
        Path p = Path.of("review-flow-marker.md");
        assertTrue(Files.exists(p), "review-flow-marker.md should exist");
        String content = Files.readString(p);
        assertEquals("# Review Flow Marker\n", content, "file content must match exactly with trailing newline");
    }
}
