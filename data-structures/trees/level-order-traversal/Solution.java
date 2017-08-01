   /* 
       
       class Node 
          int data;
          Node left;
          Node right;
      */
   void levelOrder(Node root) {
    if (root == null) {
     return;
    }

    Queue < Node > queue = new LinkedList < Node > ();
    queue.add(root);

    while (!queue.isEmpty()) {
     Node current = queue.poll();
     System.out.print(current.data + " ");

     if (current.left != null) {
      queue.add(current.left);
     }

     if (current.right != null) {
      queue.add(current.right);
     }
    }
   }