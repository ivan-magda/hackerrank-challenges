/*
  Get Nth element from the end in a linked list of integers
  Number of elements in the list will always be greater than N.
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
int GetNode(Node head, int positionFromTail) {
    Node current = head;
    Node result = head;
    int offset = 0;
    
    while(current != null) {
        current = current.next;

        if (offset > positionFromTail) {
            result = result.next;
        }

        offset++;
    }
    
    return result.data;
}

int GetNode(Node head, int n) {
    List<Integer> list = new ArrayList<>(16);    
    
    Node current = head;
    while (current != null) {
        list.add(current.data);
        current = current.next;
    }
    
    return list.get((list.size() - 1) - n);
}

