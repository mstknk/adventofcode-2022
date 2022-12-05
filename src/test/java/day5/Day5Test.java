package day5;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day5Test {
    @Test
    void assertThatPart1Result() throws IOException {
        Path path = FileSystems.getDefault().getPath("src/test/resources/day5_input.txt");
        List<String> data = Files.readAllLines(path);
        String result = Day5.getResult(data, false);

        assertEquals("CMZ", result);
    }

    @Test
    void assertThatPart2Result() throws IOException {
        Path path = FileSystems.getDefault().getPath("src/test/resources/day5_input.txt");
        List<String> data = Files.readAllLines(path);
        String result = Day5.getResult(data, true);

        assertEquals("MCD", result);
    }
}
