package tree;

public class IMRedBlackTree {

    private Node root;

    public IMRedBlackTree() {
        this.root = null;
    }

    public IMRedBlackTree(Node root) {
        this.root = root;
    }

    public IMRedBlackTree(int data) {
        this(new Node(data));
    }

    public Node getRoot() {
        return root;
    }
}
