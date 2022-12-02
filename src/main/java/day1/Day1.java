package day1;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Day1 {
    public static void main(String[] args) throws IOException {
        Path path = FileSystems.getDefault().getPath("src/main/resources/day1_input.txt");
        List<String> data = Files.readAllLines(path);

        System.out.println(getPart1Result(data));
        System.out.println(getPart2Result(data));
    }

    public static Long getPart1Result(List<String> data) {
        List<Long> list = extractedCalories(data);
        return list.stream().mapToLong(e -> e).max().orElseThrow(NoSuchElementException::new);
    }

    public static Long getPart2Result(List<String> data) {
        List<Long> list = extractedCalories(data);
        return list.get(0) + list.get(1) + list.get(2);
    }

    private static List<Long> extractedCalories(List<String> data) {
        List<Long> list = new ArrayList<>();
        long i = 0;
        for (String str : data) {
            if (str.isBlank()) {
                list.add(i);
                i = 0;
            } else {
                i += Long.parseLong(str);
            }
        }
        list.add(i);
        return list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }
}
