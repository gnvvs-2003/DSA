// Maximum Sum Path in Binary Tree
public class MaxSumPathInBT{
    public static void main(String[]args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);
        System.out.println("Maximum Path Sum: " + maxPathSum(root));
    }
    /*
     * max sum path : max (left subtree sum + right subtree sum) + curve point
     */
    static int findMaxPathSum(Node root,int[]maxi){
        // base case
        if (root == null){
            return 0;
        }
        // left max 
        int leftPath =findMaxPathSum(root.left,maxi);
        int leftMaxPath = Math.max(0,leftPath);
        // right max 
        int rightPath =findMaxPathSum(root.right,maxi);
        int rightMaxPath = Math.max(0,rightPath);
        // update the maximum value
        maxi[0] = Math.max(maxi[0],leftMaxPath+rightMaxPath+root.data);
        return Math.max(leftMaxPath,rightMaxPath)+root.data;
    }
    static int maxPathSum(Node root){
        int[] maxi = {Integer.MIN_VALUE};
        findMaxPathSum(root,maxi);
        return maxi[0];
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