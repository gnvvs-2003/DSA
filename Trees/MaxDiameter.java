// Diameter here is calculated as no of edges in between

public class MaxDiameter{
    public static void main(String[]args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);
        
        System.out.println(getMaxDiameter(root));
        
    }
    
    static int diameter = 0;
    
    /*
     * Diameter of 2 leaf nodes at a curving point
            = 1+leftSubTreeHeight+rightSubTreeHeight
     */
    public static int height(Node root){
        // base case 
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        diameter = Math.max(diameter,leftHeight+rightHeight);
        // diameter = Math.max(diameter,leftHeight+rightHeight+1); if we want in terms of nodes not edges 
        return 1+Math.max(leftHeight,rightHeight);
    }
    
    public static int getMaxDiameter(Node root){
        int res = height(root);
        return diameter;
    }
}

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