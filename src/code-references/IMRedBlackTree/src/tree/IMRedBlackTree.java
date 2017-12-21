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
}
