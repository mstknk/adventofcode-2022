package day8;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day8Test {
    @Test
    void assertThatPart1Result() throws IOException {
        Path path = FileSystems.getDefault().getPath("src/test/resources/day8_input.txt");
        List<String> data = Files.readAllLines(path);
        int result = Day8.getPart1Result(data);

        assertEquals(21, result);
    }

    @Test
    void assertThatPart2Result() throws IOException {
        Path path = FileSystems.getDefault().getPath("src/test/resources/day8_input.txt");
        List<String> data = Files.readAllLines(path);
        int result = Day8.getPart2Result(data);

        assertEquals(8, result);
    }
}
