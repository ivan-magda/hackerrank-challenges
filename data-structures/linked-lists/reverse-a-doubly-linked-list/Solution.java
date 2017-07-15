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
Node Reverse(Node head) {
    Node temp = null;  
    Node current = head;
    
    while (current !=  null) {
        temp = current.prev;
        current.prev = current.next;
        current.next = temp;              
        current = current.prev;
    }      
    
    if (temp != null) {
        head = temp.prev;
    }

    return head;
}
