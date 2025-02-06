package day06;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionPart1Test {
    @Test
    void testCountSteps() throws IOException {
        String content = Files.readString(Path.of("src/test/resources/day06.txt"), StandardCharsets.UTF_8);
        var lines = FetcherDay06.splitLines(content);
        int count = SolutionPart1.countSteps(lines);
        assertEquals(41, count);
    }
}
