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
