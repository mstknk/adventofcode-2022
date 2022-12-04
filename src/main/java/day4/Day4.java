package day4;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day4 {
    public static void main(String[] args) throws IOException {
        Path path = FileSystems.getDefault().getPath("src/main/resources/day4_input.txt");
        List<String> data = Files.readAllLines(path);
        System.out.println(getPart1Result(data));
        System.out.println(getPart2Result(data));
    }

    public static int getPart1Result(List<String> data) {
        int sum = 0;
        for (String str : data) {
            String[] asd = str.split(",");
            boolean isContains = checkContains(asd[0], asd[1], true);
            if (isContains) {
                sum++;
            }
        }
        return sum;
    }

    private static boolean checkContains(String p1, String p2, boolean isFullyContain) {
        String[] pair1 = p1.split("-");
        String[] pair2 = p2.split("-");
        int p1S1 = Integer.parseInt(pair1[0]);
        int p1S2 = Integer.parseInt(pair1[1]);
        int p2S1 = Integer.parseInt(pair2[0]);
        int p2S2 = Integer.parseInt(pair2[1]);
        if (p1S1 < p2S1) {
            return isFullyContain ? checkFullyContains(p1S1, p1S2, p2S1, p2S2) : checkAnyContains(p1S1, p1S2, p2S1, p2S2);
        } else if (p1S2 > p2S2) {
            return isFullyContain ? checkFullyContains(p1S1, p1S2, p2S1, p2S2) : checkAnyContains(p1S1, p1S2, p2S1, p2S2);
        }

        return isFullyContain ? checkFullyContains(p2S1, p2S2, p1S1, p1S2) : checkAnyContains(p2S1, p2S2, p1S1, p1S2);
    }

    private static boolean checkFullyContains(int start, int stop, int check1, int check2) {
        return check1 >= start && check1 <= stop && check2 <= stop && check2 >= start;
    }

    private static boolean checkAnyContains(int start, int stop, int check1, int check2) {
        return (check1 >= start && check1 <= stop) || (check2 <= stop && check2 >= start);
    }

    public static int getPart2Result(List<String> data) {
        int sum = 0;
        for (String str : data) {
            String[] asd = str.split(",");
            boolean isContains = checkContains(asd[0], asd[1], false);
            if (isContains) {
                sum++;
            }
        }
        return sum;
    }
}
