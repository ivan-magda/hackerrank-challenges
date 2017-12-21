package tree;

public class IMRedBlackBST {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    public IMRedBlackBST() {
        this.root = null;
    }

    public IMRedBlackBST(Node root) {
        insert(root);
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

    public void insert(int data) {
        insert(new Node(data));
    }

    private void insert(Node node) {
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

        node.setColor(RED);
        insertFixUp(node);
    }

    private void insertFixUp(Node node) {
        // While there is a violation of the RedBlackTree properties..
        while (node.getParent() != null && node.getParent().isRed()) {
            // If node's parent is the the left child of it's parent.
            if (node.getParent() == node.getParent().getParent().getLeft()) {
                Node uncle = node.getParent().getParent().getRight();
                // Case 1.
                // Поскольку z и его родитель красные, то нарушается свойство 4.
                // Поскольку, дядя z, узел y, красный, то мы перекрашиваем узлы и перемещаем указатель z вверх по дереву.
                if (uncle.isRed()) {
                    node.getParent().setColor(BLACK);
                    uncle.setColor(BLACK);
                    node.getParent().getParent().setColor(RED);
                    node = node.getParent().getParent();
                // Case 2: if node is black & node is a right child.
                } else if (node == node.getParent().getRight()) {
                    // leftRotate around node's parent
                    node = node.getParent();
                    leftRotate(node);
                // Case 3: else uncle is black AND node is a left child
                } else {
                    // recolor and rotate round z's grandpa
                    node.getParent().setColor(BLACK);
                    node.getParent().getParent().setColor(RED);
                    rightRotate(node.getParent().getParent());
                }
            // If node's parent is the right child of it's parent.
            } else {
                Node uncle = node.getParent().getParent().getLeft();

                if (uncle.isRed()) {
                    node.getParent().setColor(BLACK);
                    uncle.setColor(BLACK);
                    node.getParent().getParent().setColor(RED);
                    node = node.getParent().getParent();
                } else if (node == node.getParent().getLeft()) {
                    node = node.getParent();
                    rightRotate(node);
                } else {
                    node.getParent().setColor(BLACK);
                    node.getParent().getParent().setColor(RED);
                    leftRotate(node.getParent().getParent());
                }
            }
        }

        root.setColor(BLACK);
    }
}
