package com.example;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class E2EMarkerTest {

    @Test
    void e2eMarkerFileExistsWithExpectedContent() throws Exception {
        Path p = Path.of("e2e-marker.md");
        assertTrue(Files.exists(p), "e2e-marker.md should exist at project root");
        String content = Files.readString(p).trim();
        assertEquals("# E2E Test Passed", content, "e2e-marker.md should contain the expected marker text");
    }
}
