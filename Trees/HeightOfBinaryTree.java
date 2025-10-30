import java.util.*;
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

public class HeightOfBinaryTree{
    /*
     * Using BFS : row scan
     * A queue is maintained and a 2D table is maintained
     * queue contains the row 
     * 2D array contains the all elements
     */
    public static int height(Node root){
        // base case 
        if (root == null){
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        int level = 0;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for (int i=0;i<size;i++){
                Node front = q.poll();
                // adding child
                if(front.left != null){
                    q.add(front.left);
                }
                if(front.right != null){
                    q.add(front.right);
                }
            }
            // proceed with next level
            level++;
        }
        return level;
    }
    public static void main(String[]a){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.right.left = new Node(4);
        root.right.right = new Node(6);
        root.right.left.left = new Node(5);
        int depth = height(root);
        System.out.println("The max height = "+depth);
    }
}