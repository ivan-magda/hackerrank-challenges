/*
  Insert Node at a given position in a linked list 
  head can be NULL 
  First element in the linked list is at position 0
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
Node InsertNth(Node head, int data, int position) {
    Node newNode = new Node();
    newNode.data = data;
    
    int count = 0;
    Node prev = null;
    Node current = head;
    
    while (current != null && count < position) {
        prev = current;
        current = current.next;
        count++;
    }
    
    if (prev == null) {
        newNode.next = current;
        return newNode;
    } else {
        newNode.next = current;
        prev.next = newNode;
    }
    
    return head;
}
