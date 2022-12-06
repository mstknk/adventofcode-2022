package day6;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day6Test {
    @Test
    void assertThatPart1TestCase1() throws IOException {
        int result = Day6.getResult("bvwbjplbgvbhsrlpgdmjqwftvncz", 4);
        assertEquals(5, result);
    }

    @Test
    void assertThatPart1TestCase2() throws IOException {
        int result = Day6.getResult("nppdvjthqldpwncqszvftbrmjlhg", 4);
        assertEquals(6, result);
    }

    @Test
    void assertThatPart1TestCase3() throws IOException {
        int result = Day6.getResult("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 4);
        assertEquals(10, result);
    }

    @Test
    void assertThatPart1TestCase4() throws IOException {
        int result = Day6.getResult("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 4);
        assertEquals(11, result);
    }

    @Test
    void assertThatPart2TestCase1() throws IOException {
        int result = Day6.getResult("bvwbjplbgvbhsrlpgdmjqwftvncz", 14);
        assertEquals(23, result);
    }

    @Test
    void assertThatPart2TestCase2() throws IOException {
        int result = Day6.getResult("nppdvjthqldpwncqszvftbrmjlhg", 14);
        assertEquals(23, result);
    }

    @Test
    void assertThatPart2TestCase3() throws IOException {
        int result = Day6.getResult("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 14);
        assertEquals(29, result);
    }

    @Test
    void assertThatPart2TestCase4() throws IOException {
        int result = Day6.getResult("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 14);
        assertEquals(26, result);
    }
}
