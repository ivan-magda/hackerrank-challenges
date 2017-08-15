/*
  Delete Node at a given position in a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
Node Delete(Node head, int position) {
    int count = 0;
    Node prev = null;
    Node current = head;
    
    while (current != null && count < position) {
        count++;
        prev = current;
        current = current.next;
    }
    
    if (prev == null) {
        head = head.next;
    } else {
        prev.next = current.next;
    }
    
    
    return head;
}
