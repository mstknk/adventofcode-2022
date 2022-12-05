package day5;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Day5 {
    public static void main(String[] args) throws IOException {
        Path path = FileSystems.getDefault().getPath("src/main/resources/day5_input.txt");
        List<String> data = Files.readAllLines(path);

        System.out.println("part1 : " + getResult(data, false));
        System.out.println("part2 : " + getResult(data, true));
    }

    public static String getResult(List<String> data, boolean isSameOrder) {
        List<Stack> stackList = getStacks(data);
        List<Movement> steps = getMovements(data);

        for (Movement move : steps) {
            if (move.getStack() == 1 || !isSameOrder) {
                for (int i = 0; i < move.getStack(); i++) {
                    Object element = stackList.get(move.from - 1).pop();
                    stackList.get(move.to - 1).push(element);
                }
            } else {
                List<String> temp = new ArrayList<>();
                for (int i = 0; i < move.getStack(); i++) {
                    temp.add(stackList.get(move.from - 1).pop().toString());
                }
                for (int i = temp.size(); i > 0; i--) {
                    stackList.get(move.to - 1).push(temp.get(i - 1));
                }
            }

        }
        return stackList.stream()
                .map(e -> e.peek())
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    private static List<Stack> getStacks(List<String> data) {
        List<Stack> stackList = new ArrayList<>();
        info info = getInfo(data);
        for (int j = 0; j < info.getTotalStack(); j++) {
            Stack<String> myStack = new Stack<>();
            for (int i = 0; i < info.getSize(); i++) {
                String fullStr = data.get(info.getSize() - 1 - i);
                String str = fullStr.substring(j * 3 + j, 3 * j + 3 + j);
                if (!str.isBlank()) {
                    String cleanStr = str.replace("[", "").replace("]", "");
                    myStack.push(cleanStr);
                }
            }
            stackList.add(myStack);
        }
        return stackList;
    }

    private static List<Movement> getMovements(List<String> data) {
        List<Movement> steps = new ArrayList<>();
        for (String str : data) {
            if (str.contains("move")) {
                String stack = str.substring(5, str.indexOf("from") - 1);
                String from = str.substring(str.indexOf("from") + 5, str.indexOf("to") - 1);
                String to = str.substring(str.indexOf("to") + 3, str.length());
                Movement move = new Movement(Integer.valueOf(stack), Integer.valueOf(from), Integer.valueOf(to));
                steps.add(move);
            }
        }
        return steps;
    }

    private static info getInfo(List<String> data) {
        int size = 0;
        for (String str : data) {
            if (str.startsWith(" 1   ")) {
                String totalStack = str.substring(str.lastIndexOf(" ") + 1, str.length());
                return new info(size, Integer.valueOf(totalStack));
            }
            size++;
        }
        throw new RuntimeException();
    }

    private static class Movement {
        private int Stack;
        private int from;
        private int to;

        public Movement(int stack, int from, int to) {
            Stack = stack;
            this.from = from;
            this.to = to;
        }

        public int getStack() {
            return Stack;
        }

        public void setStack(int stack) {
            Stack = stack;
        }

        public int getFrom() {
            return from;
        }

        public void setFrom(int from) {
            this.from = from;
        }

        public int getTo() {
            return to;
        }

        public void setTo(int to) {
            this.to = to;
        }
    }

    private static class info {
        int size;
        int totalStack;

        public info(int size, int totalStack) {
            this.size = size;
            this.totalStack = totalStack;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotalStack() {
            return totalStack;
        }

        public void setTotalStack(int totalStack) {
            this.totalStack = totalStack;
        }
    }
}
