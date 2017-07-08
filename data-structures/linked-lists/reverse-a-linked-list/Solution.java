/*
  Reverse a linked list and return pointer to the head
  The input list will have at least one element  
  Node is defined as  
  class Node {
     int data;
     Node next;
  }
*/
Node Reverse(Node head) {
    if (head == null) {
        return null;
    }
    
    Node previous = null;
    Node current = head;
    Node next;
    
    while (current != null) {
        next = current.next;
        current.next = previous;
        previous = current;
        current = next;
    }
    head = previous;
    
    return head;
}

Node reverse(Node head) {
    if (head == null) {
        return null;
    }
    
    List<Integer> list = new ArrayList<>(16);
    Node current = head;
    
    while (current != null) {
        list.add(current.data);
        current = current.next;
    }

    Node reversed = new Node();
    reversed.data = list.get(list.size() - 1);
    current = reversed;

    for (int i = list.size() - 2; i >= 0; i--, current = current.next) {
        Node newNode = new Node();
        newNode.data = list.get(i);
        current.next = newNode;
    }

    return reversed;
}
