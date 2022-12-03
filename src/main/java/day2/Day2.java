package day2;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static day2.HandShapeType.*;

public class Day2 {
    private static Map<String, HandShapeType> opponentMap = Map.of("A", ROCK, "B", PAPER, "C", SCISSORS);
    private static Map<String, HandShapeType> youMap = Map.of("X", ROCK, "Y", PAPER, "Z", SCISSORS);

    public static void main(String[] args) throws IOException, IllegalAccessException {
        Path path = FileSystems.getDefault().getPath("src/main/resources/day2_input.txt");
        List<String> data = Files.readAllLines(path);
        System.out.println(getResult(data, false));
        System.out.println(getResult(data, true));
    }

    public static int getResult(List<String> data, boolean isHowToEnd) throws IllegalAccessException {
        int totalScore = 0;
        for (String str : data) {
            String[] split = str.split(" ");
            String opponentStr = split[0];
            HandShapeType opponent = opponentMap.get(opponentStr);
            String youStr = split[1];
            HandShapeType you = isHowToEnd ? getHandShapeTypeByHowToEnd(opponent, youStr) : youMap.get(youStr);
            totalScore += getScore(opponent, you) + you.getScore();
        }
        return totalScore;
    }

    private static HandShapeType getHandShapeTypeByHowToEnd(HandShapeType opponent, String youStr) throws IllegalAccessException {
        if (youStr.equals("Y")) {
            return opponent;
        }
        if (youStr.equals("X")) {
            return opponent.getLoseHandShapeType();
        }
        if (youStr.equals("Z")) {
            return opponent.getWinHandShapeType();
        }
        throw new IllegalAccessException();
    }

    private static int getScore(HandShapeType opponent, HandShapeType you) {
        if (opponent == you) {
            return 3;
        }

        if (you == ROCK && opponent == SCISSORS) {
            return 6;
        }
        if (you == SCISSORS && opponent == PAPER) {
            return 6;
        }
        if (you == PAPER && opponent == ROCK) {
            return 6;
        }
        return 0;
    }

}
