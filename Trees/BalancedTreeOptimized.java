/*
 * Using post order for calculating the heights
 * In previous approach 
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight,rightHeight)+1;
 * We calculating both heights again in isBalanced which increases the complexity
 * Optimal approach
 * Check left sub tree next right sub tree then parent node 
 */

public class BalancedTreeOptimized{
    public static boolean isBalanced(Node root){
        return heightDiff(root) != -1;
    }
    public static int heightDiff(Node root){
        // base case 
        if(root == null){
            return 0;
        }
        int leftHeight = heightDiff(root.left);
        if (leftHeight == -1){ // check for all left sub tree
            return -1;
        }
        int rightHeight = heightDiff(root.right);
        if (rightHeight == -1){ // check for all right sub tree
            return -1;
        }
        if (Math.abs(leftHeight-rightHeight)>1){
            return -1;
        }
        return Math.max(leftHeight,rightHeight)+1;
    }
    public static void main (String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);
        System.out.println(isBalanced(root));
    }
}