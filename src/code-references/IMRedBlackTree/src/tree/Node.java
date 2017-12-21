package tree;

public class Node {

    private int data;

    private Node parent;

    private Node left;

    private Node right;

    private boolean isRed;

    public Node(int data) {
        this.data = data;
        this.isRed = true;
        parent = left = right = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setColor(boolean red) {
        isRed = red;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public int getDepth() {
        Node current = this;
        int depth = 0;

        while (current.parent != null) {
            current = current.parent;
            depth++;
        }

        return depth;
    }

    @Override
    public String toString() {
        String text = "";

        if (left != null) {
            text += "(" + left.toString() + ") <- ";
        }

        String color = isRed ? "{r}" : "{b}";
        text += String.valueOf(data) + color;

        if (right != null) {
            text += " -> (" + right.toString() + ")";
        }

        return text;
    }
}
