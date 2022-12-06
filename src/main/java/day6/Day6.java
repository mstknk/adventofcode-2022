package day6;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day6 {
    public static void main(String[] args) throws IOException {
        Path path = FileSystems.getDefault().getPath("src/main/resources/day6_input.txt");
        List<String> data = Files.readAllLines(path);
        System.out.println("part1 :" + getResult(data.get(0), 4));
        System.out.println("part2 :" + getResult(data.get(0), 14));
    }

    public static int getResult(String input, int characterSize) {
        for (int i = 0; i < input.length(); i++) {
            int markerPoint = i + characterSize;
            String str = input.substring(i, markerPoint);
            if (hasMarker(str, characterSize)) {
                return markerPoint;
            }
        }
        return 1;
    }

    private static boolean hasMarker(String str, int characterSize) {
        for (int j = 0; j < characterSize; j++) {
            char character = str.charAt(j);
            long count = str.chars().filter(e -> e == character).count();
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}
