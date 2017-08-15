/*  
   class Node
      public  int frequency; // the frequency of this tree
       public  char data;
       public  Node left, right;
    
*/ 

void decode(String S, Node root){
    StringBuilder output = new StringBuilder();
  Node current = root;
    
    while (!S.isEmpty()) {
        if (S.charAt(0) == '1') {
            current = current.right;
            S = S.substring(1);
        } else {
            current = current.left;
            S = S.substring(1);
        }
        
        if (isLeaf(current)) {
            output.append(current.data);
            current = root;
        }
    }
    
    System.out.println(output.toString());
}

static boolean isLeaf(Node node) {
    return node.left == null && node.right == null;
}
