/*
  Merge two linked lists 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
Node mergeLists(Node headA, Node headB) {
    if (headA == null && headB == null) {
        return null;
    } else if (headA == null) {
        return headB;
    } else if (headB == null) {
        return headA;
    }
    
    Node merged;
    if (headA.data < headB.data) {
        merged = headA;
        merged.next = mergeLists(headA.next, headB);
    } else {
        merged = headB;
        merged.next = mergeLists(headA, headB.next);
    }
    
    return merged;
}

private static Node mergeLists(Node headA, Node headB) {
    if (headA == null) return headB;
    if (headB == null) return headA;

    Node merged = new Node();
    Node curMerged = merged;
    Node curA = headA;
    Node curB = headB;

    if (curA.data <= curB.data) {
        curMerged.data = curA.data;
        curA = curA.next;
    } else {
        curMerged.data = curB.data;
        curB = curB.next;
    }

    while (curA != null && curB != null) {
        if (curA.data <= curB.data) {
            curMerged.next = curA;
            curA = curA.next;
        } else {
            curMerged.next = curB;
            curB = curB.next;
        }

        curMerged = curMerged.next;
    }

    if (curA != null) {
        curMerged.next = curA;
    } else {
        curMerged.next = curB;
    }

    return merged;
}
