

 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */

static Node lca(Node root,int v1,int v2) {
    if (root == null) {
        return null;
    }
    
    if (root.data == v1 || root.data == v2) {
        return root;
    }
    
    Node lhs = lca(root.left, v1, v2);
    Node rhs = lca(root.right, v1, v2);
    
    if (lhs != null && rhs != null) {
        return root;
    }
    
    return (lhs != null) ? lhs : rhs;
}
