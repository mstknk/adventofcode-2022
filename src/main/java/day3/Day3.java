package day3;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
public class Day3 {
    public static void main(String[] args) throws IOException {
        Path path = FileSystems.getDefault().getPath("src/main/resources/day3_input.txt");
        List<String> data = Files.readAllLines(path);
        System.out.println(getPart2Result(data));
    }

    public static int getPart2Result(List<String> data) {
        int sum = 0;
        for (int i = 0; i < data.size(); i++) {
            char appearingItem = findAppearingItemThree(data.get(i), data.get(i + 1), data.get(i + 2));
            sum += getPriority(appearingItem);
            i = i + 2;
        }
        return sum;
    }

    public static int getPart1Result(List<String> data) {
        int sum = 0;
        for (String str : data) {
            String item1 = str.substring(0, str.length() / 2);
            String item2 = str.substring(str.length() / 2, str.length());
            char appearingItem = findAppearingItem(item1, item2);
            sum += getPriority(appearingItem);
        }
        return sum;
    }

    private static int getPriority(char appearingItem) {
        if (Character.isUpperCase(appearingItem)) {
            return Integer.valueOf(appearingItem) - 38;
        }
        return Integer.valueOf(appearingItem) - 96;
    }

    private static char findAppearingItem(String item1, String item2) {
        for (int i = 0; i < item1.length(); i++) {
            char item = item1.charAt(i);
            if (item2.contains(String.valueOf(item))) {
                return item;
            }
        }
        throw new RuntimeException();
    }

    private static char findAppearingItemThree(String item1, String item2, String item3) {
        for (int i = 0; i < item1.length(); i++) {
            char item = item1.charAt(i);
            if (item2.contains(String.valueOf(item)) && item3.contains(String.valueOf(item))) {
                return item;
            }
        }
        throw new RuntimeException();
    }
}
