/*
  Compare two linked lists A and B
  Return 1 if they are identical and 0 if they are not. 
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
int CompareLists(Node headA, Node headB) {
    if (headA == null && headB == null) {
        return 1;
    } else if (headA == null && headB != null) {
        return 0;
    } else if (headA != null && headB == null) {
        return 0;
    }
    
    if (headA.data != headB.data) {
        return 0;
    }
    
    return CompareLists(headA.next, headB.next);
}

int CompareLists(Node headA, Node headB) {
    Node curA = headA;
    Node curB = headB;
    
    while (curA != null && curB != null) {
        if (curA.data != curB.data) {
            return 0;
        }
        
        curA = curA.next;
        curB = curB.next;
    }
    
    if (curA == null && curB != null) return 0;
    if (curB == null && curB != null) return 0;
    
    return 1;
}
