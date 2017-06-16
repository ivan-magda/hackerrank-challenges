import java.util.*;

class Node {

    private static final int NUMBER_OF_CHARACTERS = 26;

    private Node[] children = new Node[NUMBER_OF_CHARACTERS];
    private int size = 0;

    public void add(String string) {
        add(string, 0);
    }

    public int findCount(String string) {
        return findCount(string, 0);
    }

    private Node getNode(char c) {
        return children[getCharIndex(c)];
    }

    private void setNode(char c, Node node) {
        children[getCharIndex(c)] = node;
    }

    private void add(String string, int index) {
        size++;
        
        if (index == string.length()) {
            return;
        }

        char current = string.charAt(index);
        Node child = getNode(current);

        if (child == null) {
            child = new Node();
            setNode(current, child);
        }

        child.add(string, index + 1);
    }

    private int findCount(String string, int index) {
        if (index == string.length()) {
            return size;
        }

        Node child = getNode(string.charAt(index));
        if (child == null) {
            return 0;
        }

        return child.findCount(string, index + 1);
    }

    private static int getCharIndex(char c) {
        return c - 'a';
    }
}

class Solution {

    private static final String OPERATION_ADD = "add";
    private static final String OPERATION_FIND = "find";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Node trie = new Node();
        int count = in.nextInt();

        for (int i = 0; i < count; i++) {
            String operationType = in.next();
            String contact = in.next();

            switch (operationType) {
                case OPERATION_ADD:
                    trie.add(contact);
                    break;
                case OPERATION_FIND:
                    System.out.println(trie.findCount(contact));
                    break;
                default:
                    throw new IllegalStateException();
            }
        }

        in.close();
    }
}
