import java.util.Scanner;

class Node<T extends Comparable<T>> {

    private T data;
    private Node<T> next;

    Node(T data) {
        this.data = data;
        next = null;
    }

    public static <T extends Comparable<T>> Node<T> insert(Node<T> head, T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
        } else if (head.next == null) {
            head.next = newNode;
        } else {
            Node start = head;
            while (start.next != null) start = start.next;
            start.next = newNode;
        }

        return head;
    }

    public static <T extends Comparable<T>> Node<T> removeDuplicates(Node<T> head) {
        if (head == null) {
            return null;
        }

        Node<T> filtered = new Node<>(head.data);
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
            if (!contains(filtered, current.data)) {
                filtered = insert(filtered, current.data);
            }
        }

        return filtered;
    }

    public static <T extends Comparable<T>> boolean contains(Node<T> head, T element) {
        if (head.data == element) {
            return true;
        }

        Node<T> start = head;
        while (start.next != null) {
            start = start.next;
            if (start.data == element) {
                return true;
            }
        }

        return false;
    }

    public static <T extends Comparable<T>> void display(Node<T> head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
        System.out.println("");
    }
}

class Solution{
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();
        Node<Integer> head = null;

        while (count-- > 0) {
            int element = in.nextInt();
            head = Node.insert(head, element);
        }
        in.close();

        head = Node.removeDuplicates(head);
        Node.display(head);
    }
}
