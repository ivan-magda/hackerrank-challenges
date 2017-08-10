import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private static final int QUERY_TYPE_ENQUEUE = 1;
    private static final int QUERY_TYPE_DEQUEUE = 2;
    private static final int QUERY_TYPE_PRINT = 3;
    
    static class IMQueue<T> {
        private Stack<T> inbox = new Stack<>();
        private Stack<T> outbox = new Stack<>() ;
        
        public void enqueue(T element) {
            inbox.push(element);
        }
        
        public T dequeue() {
            if (outbox.isEmpty()) {
                refill();
            }
            
            return outbox.pop();
        }
        
        public T peek() {
            if (outbox.isEmpty()) {
                refill();
            }
            
            return outbox.peek();
        }
        
        private void refill() {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IMQueue<Integer> queue = new IMQueue();
        
        int queries = scanner.nextInt();
        for (int i = 0; i < queries; i++) {
            int type = scanner.nextInt();
            
            switch (type) {
                case QUERY_TYPE_ENQUEUE:
                    int value = scanner.nextInt();
                    queue.enqueue(value);
                    break;
                case QUERY_TYPE_DEQUEUE:
                    queue.dequeue();
                    break;
                case QUERY_TYPE_PRINT:
                    System.out.println(queue.peek());
                    break;
            }
        }
        
        scanner.close();
    }
}
