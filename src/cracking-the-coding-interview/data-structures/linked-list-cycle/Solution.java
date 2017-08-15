/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycleSet(Node head) {
    if (head == null) return false;
    
    HashSet<Node> set = new HashSet<>();
    Node current = head;
    
    while (current.next != null) {
        if (set.contains(current)) {
            return true;
        } else {
            set.add(current);
            current = current.next;
        }
    }
    
    return false;
}

boolean hasCycle(Node head) {
    if (head == null) return false;
    
    Node fast = head.next;
    Node slow = head;
    
    while (fast != null && fast.next != null) {
        if (fast == slow) {
            return true;
        }
        
        fast = fast.next.next;
        slow = slow.next;
    }
    
    return false;
}
