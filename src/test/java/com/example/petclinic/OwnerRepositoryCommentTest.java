package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OwnerRepositoryCommentTest {

    @Test
    void ownerRepositoryHasJavadocComment() throws IOException {
        Path p = Path.of("src/main/java/com/example/petclinic/OwnerRepository.java");
        String content = Files.readString(p);
        // Expect a Javadoc-style comment immediately above the interface declaration
        int idx = content.indexOf("public interface OwnerRepository");
        boolean hasJavadoc = false;
        if (idx > 0) {
            String before = content.substring(Math.max(0, idx - 200), idx);
            hasJavadoc = before.contains("/**") && before.contains("*/");
        }
        assertTrue(hasJavadoc, "OwnerRepository should have a Javadoc comment immediately above the interface declaration");
    }
}
