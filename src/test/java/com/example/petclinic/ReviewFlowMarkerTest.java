package com.example.petclinic;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

public class ReviewFlowMarkerTest {

    @Test
    void reviewFlowMarkerFileExistsAndHasCorrectContent() throws Exception {
        Path p = Path.of("review-flow-marker.md");
        assertTrue(Files.exists(p), "review-flow-marker.md should exist in repository root");
        String content = Files.readString(p).trim();
        assertEquals("# Review Flow Marker", content, "review-flow-marker.md should contain the expected marker");
    }
}
