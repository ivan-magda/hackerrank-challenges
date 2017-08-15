/*
Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
Node RemoveDuplicates(Node head) {
    Node temp = head;

    while (temp.next != null) {
        if (temp.data == temp.next.data) {
            Node t = temp.next;
            temp.next = t.next;
        } else {
            temp = temp.next;
        }
    }

    return head;
}

private static Node removeDuplicates(Node head) {
    if (head == null) {
        return null;
    }

    Set < Integer > set = new HashSet < > (16);
    Node unique = null;
    Node uniqueCurrent = null;
    Node current = head;

    while (current != null) {
        int value = current.data;

        if (!set.contains(value)) {
            set.add(value);

            Node newNode = new Node();
            newNode.data = value;

            if (unique == null) {
                unique = newNode;
                uniqueCurrent = unique;
            } else {
                uniqueCurrent.next = newNode;
                uniqueCurrent = uniqueCurrent.next;
            }
        }

        current = current.next;
    }

    return unique;
}
