/*
  Insert Node at the end of a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
Node Insert(Node head,int data) {
    Node newNode = new Node();
    newNode.data = data;
    
    if (head == null) {
        return newNode;
    }
    
    Node current = head.next;
    if (current == null) {
        head.next = newNode;
        return head;
    }
    
    while (current.next != null) {
        current = current.next;
    }
    current.next = newNode;
    
    return head;
}
