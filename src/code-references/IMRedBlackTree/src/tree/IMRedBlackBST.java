package tree;

public class IMRedBlackBST {

    // Interfaces.

    public interface TreeWalkCallback {
        void process(int value);
    }

    // Instance Variables.

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    // Constructors.

    public IMRedBlackBST() {
        this.root = null;
    }

    public IMRedBlackBST(Node root) {
        insert(root);
    }

    public IMRedBlackBST(int data) {
        this(new Node(data));
    }

    // Getters.

    public Node getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // Rotation.

    private void leftRotate(Node node) {
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

    private void rightRotate(Node node) {
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

    // Insert.

    public void insert(int data) {
        insert(new Node(data));
    }

    private void insert(Node node) {
        Node parent = null;
        Node current = root;

        while (current != null) {
            parent = current;
            current = node.getData() < current.getData()
                    ? current.getLeft()
                    : current.getRight();
        }

        node.setParent(parent);

        if (parent == null) {
            root = node;
        } else if (node.getData() < parent.getData()) {
            parent.setLeft(node);
        } else {
            parent.setRight(node);
        }

        insertFixUp(node);
    }

    /**
     * Fixes up the violation of the RedBlackTree properties.
     *
     * @param node, the node which was inserted and may have caused a violation of the RedBlackTree properties.
     *              Fixes up the violation of the RedBlackTree properties that may have been caused during insert(node).
     */
    private void insertFixUp(Node node) {
        // While there is a violation of the RedBlackTree properties..
        while (node.getParent() != null && node.getParent().isRed()) {
            // If node's parent is the the left child of it's parent.
            if (node.getParent() == node.getParent().getParent().getLeft()) {
                Node uncle = node.getParent().getParent().getRight();
                // Case 1.
                // Поскольку z и его родитель красные, то нарушается свойство 4.
                // Поскольку, дядя z, узел y, красный, то мы перекрашиваем узлы и перемещаем указатель z вверх по дереву.
                if (uncle != null && uncle.isRed()) {
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

                if (uncle != null && uncle.isRed()) {
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

    // Delete.

    /**
     * Используется для перемещения поддеревьев в бинарном дереве поиска.
     * Заменяет одно поддерево, являющееся дочерним по отношению к своему родителю, другим поддеревом.
     */
    private void transplant(Node parent, Node child) {
        if (parent.getParent() == null) {
            root = child;
        } else if (parent == parent.getParent().getLeft()) {
            parent.getParent().setLeft(child);
        } else {
            parent.getParent().setRight(child);
        }

        if (child != null) {
            child.setParent(parent.getParent());
        }
    }

    public void delete(Node node) {
        // Преемник удаляемого узла, перемещается в дереве на позиция узла `node`.
        Node replacement = node;

        // Узел, который отслеживает перемещение узла `replacement`, который перемещается в исходную позицию
        // узла `replacement` в дереве, поскольку данный узел тоже может привести к нарушению красно-черных свойств.
        Node replacementOriginalNode;

        boolean originalColor = replacement.isRed();

        if (node.getLeft() == null) {
            replacementOriginalNode = node.getRight();
            transplant(node, node.getRight());
        } else if (node.getRight() == null) {
            replacementOriginalNode = node.getLeft();
            transplant(node, node.getLeft());
        } else {
            // В противном случае удаляемая вершина имеет левый и правый дочерние узлы. Мы находим узел y (минимальный),
            // следующий за удаляемым. Этот узел располагается в правом поддереве.
            replacement = getMinimum(node.getRight());
            originalColor = replacement.isRed();
            replacementOriginalNode = replacement.getRight();

            if (replacement.getParent() == node) {
                replacementOriginalNode.setParent(replacement);
            } else {
                // Y находится в правом поддереве узла z, но не является правым дочерним узлом z.
                // В этом случае мы сначала заменяем y его собственным правым дочерним узлом, а затем заменяем z на y.
                transplant(replacement, replacement.getRight());
                replacement.setRight(node.getRight());
                replacement.getRight().setParent(replacement);
            }

            // Y является правым дочерним узлом z, то мы заменяем z на y, оставляя нетронутым правый дочерний
            // по отношению к y узел.
            transplant(node, replacement);
            replacement.setLeft(node.getLeft());
            replacement.getLeft().setParent(replacement);
            replacement.setColor(node.isRed());
        }

        if (originalColor == BLACK) {
            deleteFixUp(replacementOriginalNode);
        }
    }

    private void deleteFixUp(Node node) {

    }

    // Search.

    public Node search(int value) {
        Node current = root;

        while (current != null && current.getData() != value) {
            current = value < current.getData()
                    ? current.getLeft()
                    : current.getRight();
        }

        return current;
    }

    public boolean contains(int value) {
        return search(value) != null;
    }

    public Node getMinimum(Node node) {
        Node minNode = node;

        while (minNode.getLeft() != null) {
            minNode = minNode.getLeft();
        }

        return minNode;
    }

    public Node getMaximum(Node node) {
        Node maxNode = node;

        while (maxNode.getRight() != null) {
            maxNode = maxNode.getRight();
        }

        return maxNode;
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node node) {
        if (node == null || node.isRed()) {
            return 0;
        } else {
            return 1 + Math.max(
                    getHeight(node.getLeft()),
                    getHeight(node.getRight())
            );
        }
    }

    public Node getSuccessor(Node node) {
        if (node == null) {
            return null;
        } else if (node.getRight() != null) {
            return getMinimum(node.getRight());
        }

        Node current = node;
        Node parent = node.getParent();

        while (parent != null && current == parent.getRight()) {
            current = parent;
            parent = parent.getParent();
        }

        return parent;
    }

    public Node getPredecessor(Node node) {
        if (node == null) {
            return null;
        } else if (node.getLeft() != null) {
            return getMaximum(node.getLeft());
        }

        Node current = node;
        Node parent = node.getParent();

        while (parent != null && current == parent.getLeft()) {
            current = parent;
            parent = parent.getParent();
        }

        return parent;
    }

    // Tree traversals.

    public void inorderTreeWalk(TreeWalkCallback treeWalkCallback) {
        inorderTraversal(root, treeWalkCallback);
    }

    private void inorderTraversal(Node node, TreeWalkCallback treeWalkCallback) {
        if (node != null) {
            inorderTraversal(node.getLeft(), treeWalkCallback);
            treeWalkCallback.process(node.getData());
            inorderTraversal(node.getRight(), treeWalkCallback);
        }
    }

    public void preorderTreeWalk(TreeWalkCallback treeWalkCallback) {
        preorderTraversal(root, treeWalkCallback);
    }

    private void preorderTraversal(Node node, TreeWalkCallback treeWalkCallback) {
        if (node != null) {
            treeWalkCallback.process(node.getData());
            preorderTraversal(node.getLeft(), treeWalkCallback);
            preorderTraversal(node.getRight(), treeWalkCallback);
        }
    }

    public void postorderTreeWalk(TreeWalkCallback treeWalkCallback) {
        postorderTraversal(root, treeWalkCallback);
    }

    private void postorderTraversal(Node node, TreeWalkCallback treeWalkCallback) {
        if (node != null) {
            postorderTraversal(node.getLeft(), treeWalkCallback);
            postorderTraversal(node.getRight(), treeWalkCallback);
            treeWalkCallback.process(node.getData());
        }
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
