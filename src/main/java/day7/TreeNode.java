package day7;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class TreeNode {
    private String name;
    private long size;
    public TreeNode parent;
    public List<TreeNode> children;

    public boolean isRoot() {
        return parent == null;
    }

    public boolean isLeaf() {
        return children.size() == 0;
    }

    public TreeNode(String name, long size) {
        this.name = name;
        this.size = size;
        this.children = new LinkedList<TreeNode>();
    }

    public TreeNode getParent() {
        return parent;
    }

    public List<TreeNode> getChildren() {
        return children;
    }


    public TreeNode addChild(String name, long size) {
        TreeNode childNode = new TreeNode(name, size);
        childNode.parent = this;
        this.children.add(childNode);
        return childNode;
    }

    Stream<TreeNode> dirs() {
        return Stream.concat(Stream.of(this), getChildren().stream().flatMap(n -> n.dirs())
                .filter(n -> n.size == 0));
    }

    public long size() {
        return size > 0 ? size : getChildren().stream().mapToLong(n -> n.size()).sum();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
