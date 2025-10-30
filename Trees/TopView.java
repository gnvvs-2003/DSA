// Top view of a binary tree
import java.util.*;

public class TopView{
    public static List<Integer> topView (Node root){
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Map<Integer,Integer> mapping = new TreeMap<>();
        Queue<Pair<Node,Integer>> q = new LinkedList<>(); // node , horizontal position
        q.add(new Pair<>(root,0));
        while(!q.isEmpty()){
            Pair<Node,Integer> pair = q.poll();
            Node node = pair.getKey();
            int line = pair.getValue(); // horizontal position
            if(!mapping.containsKey(line)){ // No element exits at horizontal position
                mapping.put(line,node.data);
            }
            // left and right chils
            if (node.left != null) {
                // Push the left child with a decreased
                // vertical position into the queue
                q.add(new Pair<>(node.left, line - 1));
            }
            
            // Process right child
            if (node.right != null) {
                // Push the right child with an increased
                // vertical position into the queue
                q.add(new Pair<>(node.right, line + 1));
            }
        }
        for(int val : mapping.values()){
            ans.add(val);
        }
        return ans;
    }
    public static void main(String[]args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);
        
        for(int topViewPath : topView(root)){
            System.out.print(topViewPath+" ");
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

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }
}