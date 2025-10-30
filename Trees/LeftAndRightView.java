import java.util.*;

class LeftAndRightView{
    public static List<Integer> leftView(Node root){
        List<Integer> view = new ArrayList<>();
        if(root == null){
            return view;
        }
        recursionLeftSide(root,0,view); // node,level,view
        return view;
    }
    public static void recursionLeftSide(Node node,int level,List<Integer> view){
        // base case 
        if(node == null){
            return;
        }
        // if level is the view size 
        if(level == view.size()){
            view.add(node.data);
        }
        // going left
        recursionLeftSide(node.left,level+1,view);
        // going right
        recursionLeftSide(node.right,level+1,view);
        
    }
    
    public static List<Integer> rightView(Node root){
        List<Integer> view = new ArrayList<>();
        if(root == null){
            return view;
        }
        recursionRightSide(root,0,view); // node,level,view
        return view;
    }
    public static void recursionRightSide(Node node,int level,List<Integer> view){
        // base case 
        if(node == null){
            return;
        }
        // if level is the view size 
        if(level == view.size()){
            view.add(node.data);
        }
        // going right
        recursionRightSide(node.right,level+1,view);
        // going left
        recursionRightSide(node.left,level+1,view);
        
    }
    public static void main(String[]args){
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);
        System.out.println("Left view");
        for(int left:leftView(root)){
            System.out.println(left+" ");
        }
        System.out.println();
        System.out.println("Right view");
        for(int right:rightView(root)){
            System.out.println(right+" ");
        }
    }
}

class Node {
    int data;
    Node left;
    Node right;

    // Constructor to initialize
    // the node with a value
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}