/*
  Find merge point of two linked lists
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
int FindMergeNode(Node headA, Node headB) {
    Node curA = headA;
    
    while (curA != null) {
        Node curB = headB;
        
        while (curB != null) {
            if (curA == curB) {
                return curA.data;
            }
            
            curB = curB.next;
        }
        
        curA = curA.next;
    }
    
    return -1;
}

int FindMergeNode(Node headA, Node headB) {
    Set<Node> set = new HashSet<>(16);
    Node currentB = headB;
    
    // Build a look up table.
    while (currentB != null) {
        set.add(currentB);
        currentB = currentB.next;
    }
    
    Node curA = headA;
    while (curA != null) {
        if (set.contains(curA)) {
            return curA.data;
        }
        
        curA = curA.next;
    }
    
    return -1;
}
