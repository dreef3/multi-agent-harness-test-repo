package com.example.petclinic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Test to verify README contains API documentation and usage examples.
 */
class ReadmeApiDocumentationTest {

    @Test
    void readmeShouldContainApiDocumentation() throws IOException {
        Path readmePath = Path.of("README.md");
        String content = Files.readString(readmePath);

        // API endpoint documentation
        assertTrue(content.contains("GET /owners"), 
            "README should document GET /owners endpoint");
        assertTrue(content.contains("GET /owners/{id}"), 
            "README should document GET /owners/{id} endpoint");
        assertTrue(content.contains("POST /owners"), 
            "README should document POST /owners endpoint");
    }

    @Test
    void readmeShouldContainUsageExamples() throws IOException {
        Path readmePath = Path.of("README.md");
        String content = Files.readString(readmePath);

        // Should contain curl examples
        assertTrue(content.contains("curl"), 
            "README should contain curl usage examples");
        assertTrue(content.contains("--request"), 
            "README should contain curl request examples");
    }

    @Test
    void readmeShouldContainBuildInstructions() throws IOException {
        Path readmePath = Path.of("README.md");
        String content = Files.readString(readmePath);

        // Should contain build instructions
        assertTrue(content.contains("mvn"), 
            "README should contain Maven build instructions");
        assertTrue(content.contains("spring-boot"), 
            "README should reference Spring Boot");
    }
}
