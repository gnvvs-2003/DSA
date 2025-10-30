import java.util.*;
class TreeToLinkedList{
    Node prev = null;
    public static void flatten(Node root){
        // base case 
        if(root == null){
            return;
        }
        Stack<Node> s = new Stack<>();
        s.push(root);
        while(!s.empty()){
            Node current = s.pop();
            if(current.right != null){
                s.push(current.right);
            }
            if(current.left != null){
                s.push(current.left);
            }
            if(!s.empty()){
                current.right = s.peek();
            }
            current.left = null;
        }
    }
    
    public static void printLinkedList(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        printLinkedList(root.right);
    }
    
    public static void main(String[]args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.right.right = new Node(7);
        root.right.left = new Node(8);
        flatten(root);
        printLinkedList(root);
    }
}

class Node{
    int data;
    Node left;
    Node right;
    Node(int _data){
        data = _data;
        left = null;
        right = null;
    }
}