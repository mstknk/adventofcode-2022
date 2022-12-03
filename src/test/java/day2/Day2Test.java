package day2;

import day1.Day1;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day2Test {
    @Test
    void assertThatPart1Result() throws IOException, IllegalAccessException {
        Path path = FileSystems.getDefault().getPath("src/test/resources/day2_input.txt");
        List<String> data = Files.readAllLines(path);
        long result = Day2.getResult(data, false);

        assertEquals(15, result);
    }

    @Test
    void assertThatPart2Result() throws IOException, IllegalAccessException {
        Path path = FileSystems.getDefault().getPath("src/test/resources/day2_input.txt");
        List<String> data = Files.readAllLines(path);
        long result = Day2.getResult(data, true);

        assertEquals(12, result);
    }
}
