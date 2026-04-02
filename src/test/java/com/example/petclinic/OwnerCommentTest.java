package com.example.petclinic;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OwnerCommentTest {

    @Test
    void ownerFileShouldContainTopOfFileComment() throws IOException {
        String content = Files.readString(Path.of("src/main/java/com/example/petclinic/Owner.java"));
        assertTrue(content.contains("Owner model"), "Owner.java should contain a brief top-of-file comment mentioning 'Owner model'");
    }
}
