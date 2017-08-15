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

/**
 * With Set usage.
 */
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

/**
 * Best time complexity solution.
 */
int FindMergeNode(Node headA, Node headB) {
    int aLength = getLength(headA);
    int bLength = getLength(headB);
    int diff = bLength - aLength;
    
    if (aLength > bLength) {
        Node temp = headA;
        headA = headB;
        headB = temp;
        diff = aLength - bLength;
    }
    
    Node aCurrent = headA;
    Node bCurrent = headB;
    
    for (int i = 0; i < diff; i++) {
        bCurrent = bCurrent.next;
    }
    
    while (aCurrent != null && bCurrent != null) {
        if (aCurrent == bCurrent) {
            return aCurrent.data;
        }
        
        aCurrent = aCurrent.next;
        bCurrent = bCurrent.next;
    }
    
    return -1;
}

int getLength(Node head) {
    int length = 0;
    
    Node current = head;
    while (current != null) {
        length++;
        current = current.next;
    }
    
    return length;
}
