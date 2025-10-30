// Tree traversals

import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int _data){
        data = _data;
        left = null;
        right = null;
    }
}

public class Main{
    
    /*
     * Preorder Inorder Postorder Traversals in one traversal 
     * preorder : 1
     * inorder : 2
     * post order : 3
     * preorder root(1)->left->right
     * inorder left->root(2)->right
     * postorder left->right->root(3)
     */
     
    
    
    
    public static void main(String[]args){
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
    }
}