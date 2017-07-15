/*
  Insert Node at the end of a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
     Node prev;
  }
*/
Node SortedInsert(Node head, int data) {
    Node newNode = new Node();
    newNode.data = data;
    
    if (head == null) {
        return newNode;
    }
    
    Node current = head;
    
    while (current != null) {
        if (current.data > data) {
            insertBetween(current.prev, newNode, current);
            return head;
        }
        
        Node next = current.next;
        if (next != null) {
            if (current.data < newNode.data && newNode.data < next.data) {
                insertBetween(current, newNode, next);
                return head;
            }
        } else {
            current.next = newNode;
            newNode.prev = current;
            return head;
        }
        
        current = current.next;
    }
    
    return head;
}

private static void insertBetween(Node prev, Node middle, Node next) {
    if (prev != null) {
        prev.next = middle;
        middle.prev = prev;
        middle.next = next;
        next.prev = middle;
    } else {
        next.prev = middle;
        middle.next = next;
    }
}
