import java.util.*;
import java.io.*;

class Node{

    Node left, right;
    int data;

    Node(int data){
        this.data = data;
        left=right=null;
    }
}

class Solution {
    
    public static int getHeight(Node root){
        if (root == null) {
        	return -1;
        }

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static Node insert(Node root,int data){
        if(root == null){
            return new Node(data);
        } else {
            Node current;

            if (data <= root.data) {
                current = insert(root.left, data);
                root.left = current;
            } else {
                current = insert(root.right, data);
                root.right = cur;
            }

            return root;
        }
    }

    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	Node root = null;

    	while(T-- > 0){
    		int data = sc.nextInt();
    		root = insert(root,data);
    	}

    	int height = getHeight(root);
    	System.out.println(height);
    }	
}
