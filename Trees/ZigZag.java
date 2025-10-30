// Zig Zag Travesal Of Binary Tree

import java.util.*;

class ZigZag{
    
    // For Zig-Zag perform perform BFS row level traversal
    // row - 1 : -> proper
    // row -2 : <- reverse
    
    public static List<List<Integer>> zigZag(Node root){
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;
        while (!q.isEmpty()){
            int size = q.size();
            Deque<Integer> row = new LinkedList<>();
            for (int i =0 ;i<size;i++){
                Node node = q.poll();
                
                if (leftToRight) {
                    row.addLast(node.data);
                } else {
                    row.addFirst(node.data);
                }

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            ans.add(new ArrayList<>(row));
            leftToRight = !leftToRight;
        }
        return ans;
    }
    
    public static void main(String[]args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        List<List<Integer>> ans = zigZag(root);
        
        for (List<Integer> l1 : ans){
            for (int l2:l1){
                System.out.println(l2);
            }
            System.out.println();
        }
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