package day8;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day8 {
    public static void main(String[] args) throws IOException {
        Path path = FileSystems.getDefault().getPath("src/main/resources/day8_input.txt");
        List<String> data = Files.readAllLines(path);
        System.out.println("part1 :" + getPart1Result(data));
        System.out.println("part2 :" + getPart2Result(data));
    }

    public static int getPart1Result(List<String> data) {
        int[][] arr = getArray(data);
        int visibleCount = 0;
        for (var lineIndex = 0; lineIndex < arr.length; lineIndex++) {
            for (var columnIndex = 0; columnIndex < arr[lineIndex].length; columnIndex++) {
                if (isVisible(arr, lineIndex, columnIndex)) {
                    visibleCount++;
                }
            }
        }
        return visibleCount;
    }

    public static int getPart2Result(List<String> data) {
        int[][] arr = getArray(data);
        int maxScenicScore = 0;

        for (var lineIndex = 0; lineIndex < arr.length; lineIndex++) {
            for (var columnIndex = 0; columnIndex < arr[lineIndex].length; columnIndex++) {
                maxScenicScore = Math.max(maxScenicScore, scenicScore(arr, lineIndex, columnIndex));
            }
        }

        return maxScenicScore;
    }

    private static int[][] getArray(List<String> data) {
        int size = data.size();
        int[][] arr = new int[size][size];
        int y = 0;
        for (String str : data) {
            for (int i = 0; i < str.length(); i++) {
                arr[y][i] = Integer.valueOf(String.valueOf(str.charAt(i)));
            }
            y++;
        }
        return arr;
    }

    private static boolean isVisible(int[][] grid, int row, int column) {
        // Edges of the grid are always visible
        if (row == 0 || row == grid.length - 1 || column == 0 || column == grid[0].length - 1) {
            return true;
        }

        int height = grid[row][column];
        boolean visible;

        // Check top visibility
        visible = true;

        for (int gridRow = 0; gridRow < row; gridRow++) {
            if (grid[gridRow][column] >= height) {
                visible = false;
                break;
            }
        }

        if (visible) {
            return true;
        }

        // Check bottom visibility
        visible = true;

        for (int gridRow = row + 1; gridRow < grid.length; gridRow++) {
            if (grid[gridRow][column] >= height) {
                visible = false;
                break;
            }
        }

        if (visible) {
            return true;
        }

        // Check left visibility
        visible = true;

        for (int gridColumn = 0; gridColumn < column; gridColumn++) {
            if (grid[row][gridColumn] >= height) {
                visible = false;
                break;
            }
        }

        if (visible) {
            return true;
        }

        // Check right visibility
        visible = true;

        for (int gridColumn = column + 1; gridColumn < grid[row].length; gridColumn++) {
            if (grid[row][gridColumn] >= height) {
                visible = false;
                break;
            }
        }

        return visible;
    }

    private static int scenicScore(int[][] grid, int row, int column) {
        int top = 0, right = 0, bottom = 0, left = 0;
        int height = grid[row][column];

        // Calculate top score
        for (int gridRow = row - 1; gridRow >= 0; gridRow--) {
            top++;

            if (grid[gridRow][column] >= height) {
                break;
            }
        }

        // Calculate bottom score
        for (int gridRow = row + 1; gridRow < grid.length; gridRow++) {
            bottom++;

            if (grid[gridRow][column] >= height) {
                break;
            }
        }

        // Calculate left score
        for (int gridColumn = column - 1; gridColumn >= 0; gridColumn--) {
            left++;

            if (grid[row][gridColumn] >= height) {
                break;
            }
        }

        // Calculate right score
        for (int gridColumn = column + 1; gridColumn < grid[row].length; gridColumn++) {
            right++;

            if (grid[row][gridColumn] >= height) {
                break;
            }
        }

        return top * right * bottom * left;
    }
}
