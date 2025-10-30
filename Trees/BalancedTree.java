import java.util.*;

public class BalancedTree{
    /*
     * Using row level i.e BFS
     * A queue is maintained for row elements
     * A 2D array is maintained for all elements
     */
    public static int height(Node root){
        // base case
        if(root == null){
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        int level = 0;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                Node front = q.poll();
                // adding child
                if(front.left != null){
                    q.add(front.left);
                }
                if(front.right != null){
                    q.add(front.right);
                }
            }
            level +=1;
        }
        return level;
    }
    /*
     * @params : root node
     * For a balanced tree max(abs(height(RST)-height(LST))) = 1
     * RST : right sub tree
     * LST : left sub tree
     */
    public static boolean isBalanced(Node root){
        if(root == null){
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if(Math.abs(leftHeight-rightHeight)<2 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }
        return false;
    }
    public static void main(String[]args){
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
