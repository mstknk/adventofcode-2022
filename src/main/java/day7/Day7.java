package day7;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day7 {

    public static void main(String[] args) throws IOException {
        Path path = FileSystems.getDefault().getPath("src/main/resources/day7_input.txt");
        TreeNode root = getTreeNode(path);

        var part1 = part1(root);
        System.out.println("part 1 = " + part1);

        long part2 = part2(root);
        System.out.printf("part 2 = " + part2);

        printAll(root.children, 0);
    }

    public static long part2(TreeNode root) {
        var needed = 30000000 - (70000000 - root.size());
        return root.dirs()
                .filter(n -> n.size() >= needed)
                .mapToLong(n -> n.size()).sorted().findFirst().getAsLong();
    }

    public static long part1(TreeNode root) {
        return root.dirs()
                .filter(n -> n.size() <= 100000)
                .mapToLong(n -> n.size()).sum();
    }

    public static TreeNode getTreeNode(Path path) throws IOException {
        TreeNode root = null;
        List<String> data = Files.readAllLines(path);
        for (String str : data) {
            boolean isCmd = str.startsWith("$ ");
            Command cmd = isCmd ? parseCommand(str) : new Command();
            if (cmd.changeDirectory) {
                String directoryDestination = cmd.getDirectoryDestination();
                if (directoryDestination.equals("/")) {
                    root = new TreeNode("root", 0);
                } else if (directoryDestination.equals("..")) {
                    root = root.getParent();
                } else {
                    //change directory
                    root = root.getChildren().stream().filter(e -> e.getName().equals(directoryDestination)).findFirst().get();

                }
            } else if (!isCmd) {
                String[] split = str.split(" ");
                if (split[0].startsWith("dir")) {
                    root.addChild(split[1], 0);
                } else {
                    root.addChild(split[1], Long.valueOf(split[0]));
                }
            }
        }
        while (!root.isRoot()) {
            root = root.getParent();
        }
        return root;
    }

    private static void printAll(List<TreeNode> list, int repeat) {
        String space = " ".repeat(repeat);
        for (TreeNode root : list) {
            if (root.getSize() == 0) {
                System.out.println(space + " - " + root.getName() + "(dir) = " + root.dirs().mapToLong(e -> e.size()).sum());
                printAll(root.getChildren(), repeat + 1);
            } else {
                System.out.println(space + " - " + root.getName() + "(" + root.getSize() + ")");
            }
        }
    }


    private static Command parseCommand(String str) {
        if (str.equals("$ ls")) {
            return new Command();
        }
        return new Command(str.split(" ")[2]);
    }


    private static class Command {
        private boolean changeDirectory;
        private boolean list;
        private String directoryDestination;

        public Command() {
            this.list = true;
        }

        public Command(String directoryDestination) {
            this.directoryDestination = directoryDestination;
            this.changeDirectory = true;
        }

        public boolean isChangeDirectory() {
            return changeDirectory;
        }

        public void setChangeDirectory(boolean changeDirectory) {
            this.changeDirectory = changeDirectory;
        }

        public boolean isList() {
            return list;
        }

        public void setList(boolean list) {
            this.list = list;
        }

        public String getDirectoryDestination() {
            return directoryDestination;
        }

        public void setDirectoryDestination(String directoryDestination) {
            this.directoryDestination = directoryDestination;
        }
    }
}
