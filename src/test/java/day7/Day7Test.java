package day7;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day7Test {
    @Test
    void assertThatPart1() throws IOException {
        Path path = FileSystems.getDefault().getPath("src/test/resources/day7_input.txt");
        TreeNode root = Day7.getTreeNode(path);

        var part1 = Day7.part1(root);
        assertEquals(95437, part1);
    }

    @Test
    void assertThatPart2() throws IOException {
        Path path = FileSystems.getDefault().getPath("src/test/resources/day7_input.txt");
        TreeNode root = Day7.getTreeNode(path);

        var part2 = Day7.part2(root);
        assertEquals(24933642, part2);
    }
}
