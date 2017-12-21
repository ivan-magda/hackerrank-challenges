package tree;

public class IMRedBlackBST {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    public IMRedBlackBST() {
        this.root = null;
    }

    public IMRedBlackBST(Node root) {
        this.root = root;
    }

    public IMRedBlackBST(int data) {
        this(new Node(data));
    }

    public Node getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void leftRotate(Node node) {
        // Make newParent's left subtree -> right subtree of the node.
        Node newParent = node.getRight();
        node.setRight(newParent.getLeft());

        if (newParent.getLeft() != null) {
            newParent.getLeft().setParent(node);
        }

        newParent.setParent(node.getParent());

        if (node.getParent() == null) {
            root = newParent;
        } else if (node == node.getParent().getLeft()) {
            node.getParent().setLeft(newParent);
        } else {
            node.getParent().setRight(newParent);
        }

        newParent.setLeft(node);
        node.setParent(newParent);
    }

    public void rightRotate(Node node) {
        Node newParent = node.getLeft();
        node.setLeft(newParent.getRight());

        if (newParent.getRight() != null) {
            newParent.getRight().setParent(node);
        }

        newParent.setParent(node.getParent());

        if (node.getParent() == null) {
            root = newParent;
        } else if (node == node.getParent().getLeft()) {
            node.getParent().setLeft(newParent);
        } else {
            node.getParent().setRight(node);
        }

        newParent.setRight(node);
        node.setParent(newParent);
    }

    public void insert(Node node) {
        Node parent = null;
        Node current = root;

        while (current != null) {
            parent = current;
            current = node.getData() < current.getData() ? node.getLeft() : node.getRight();
        }

        node.setParent(parent);

        if (parent == null) {
            root = node;
        } else if (node.getData() < parent.getData()) {
            parent.setLeft(node);
        } else {
            parent.setRight(node);
        }

        node.setIsRed(RED);
        insertFixUp(node);
    }

    private void insertFixUp(Node node) {

    }
}
