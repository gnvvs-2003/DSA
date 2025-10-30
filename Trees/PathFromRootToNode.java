import java.util.*;

class PathFromRootToNode{
    public static boolean getPath(Node root,List<Integer> array,int target){
        if(root == null){
            return false;
        }
        array.add(root.data);
        if(root.data == target){
            return true;
        }
        if(getPath(root.left,array,target) || getPath(root.right,array,target)){
            return true;
        }
        // return if target not found and reached leaf node
        array.remove(array.size()-1);
        return false;
    }
    
    public static List<Integer> path(Node root,int target){
        List<Integer> array = new ArrayList<>();
        if(root == null){
            return array;
        }
        boolean pathAvailable = getPath(root,array,target);
        return array;
    }
    
    
    
    public static void main(String[]args){
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);
        
        for(int value : path(root,7)){
            System.out.println(value);
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