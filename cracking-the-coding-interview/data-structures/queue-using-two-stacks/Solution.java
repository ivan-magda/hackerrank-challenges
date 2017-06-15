import java.util.Scanner;

class Node {

    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class Queue {

    private Node head = null;
    private Node tail = null;

    public Queue() {
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);

        if (tail != null) {
            tail.setNext(newNode);
        }
        tail = newNode;

        if (head == null) {
            head = newNode;
        }
    }

    public int dequeue() {
        if (head == null) throw new NullPointerException("Head is null");

        int data = head.getData();
        head = head.getNext();

        if (head == null) {
            tail = null;
        }

        return data;
    }

    public int peek() {
        if (head == null) throw new NullPointerException("Head is null");
        return head.getData();
    }
}

class Solution {

    private static final int QUERY_TYPE_ENQUEUE = 1;
    private static final int QUERY_TYPE_DEQUEUE = 2;
    private static final int QUERY_TYPE_PRINT = 3;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Queue queue = new Queue();
        int queries = in.nextInt();

        for (int i = 0; i < queries; i++) {
            switch (in.nextInt()) {
                case QUERY_TYPE_ENQUEUE:
                    queue.enqueue(in.nextInt());
                    break;
                case QUERY_TYPE_DEQUEUE:
                    queue.dequeue();
                    break;
                case QUERY_TYPE_PRINT:
                    System.out.println(queue.peek());
                    break;
                default:
                    throw new IllegalArgumentException("Receive an illegal query type.");
            }
        }

        in.close();
    }
}
