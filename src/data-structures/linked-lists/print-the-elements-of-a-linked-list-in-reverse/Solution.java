/*
  Print elements of a linked list in reverse order 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
void ReversePrint(Node head) {
    if (head == null) {
        return;
    }
    
    ReversePrint(head.next);
    System.out.println(head.data);
}

void ReversePrintList(Node head) {
    List<Integer> list = new ArrayList<>(16);
    
    Node current = head;
    while (current != null) {
        list.add(current.data);
        current = current.next;
    }
    
    for (int i = list.size() - 1; i >= 0; i--) {
        System.out.println(list.get(i));
    }
}
