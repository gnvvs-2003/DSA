import java.util.*;

public class BottomView{
    public static List<Integer> bottomView(Node root){
        // BFS
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Map<Integer,Integer> mapping = new TreeMap<>();
        Queue<Pair<Node,Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root,0));
        while(!q.isEmpty()){
            Pair<Node,Integer> pair = q.poll();
            Node node = pair.getKey();
            int horizontalPosition = pair.getValue();
            mapping.put(horizontalPosition,node.data);
            if(node.left != null){
                q.add(new Pair<>(node.left,horizontalPosition-1));
            }
            if(node.right != null){
                q.add(new Pair<>(node.right,horizontalPosition+1));
            }
        }
        for(Map.Entry<Integer, Integer> entry : mapping.entrySet()) {
            ans.add(entry.getValue());
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
        
        for(int bottomViewPath : bottomView(root)){
            System.out.print(bottomViewPath+" ");
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