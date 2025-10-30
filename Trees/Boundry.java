// Boundry traversal

import java.util.*;

class Boundry{
    static boolean isLeaf (Node node){
        return node.left == null && node.right == null;
    }
    // left boundry
    static void addLeftBoundry(Node node,List<Integer> boundry){
        Node currentNode = node.left;
        while (currentNode != null){
            if(!isLeaf(currentNode)){
                boundry.add(currentNode.data);
            }
            if(currentNode.left != null){
                currentNode = currentNode.left;
            }
            else{
                currentNode = currentNode.right;
            }
        }
    }
    //  rightboundry
    static void addRightBoundry(Node node,List<Integer> boundry){
        Node currentNode = node.right;
        List<Integer> temp = new ArrayList<>();
        while (currentNode != null){
            if(!isLeaf(currentNode)){
                temp.add(currentNode.data);
            }
            if(currentNode.right != null){
                currentNode = currentNode.right;
            }
            else{
                currentNode = currentNode.left;
            }
        }
        for(int i = temp.size()-1;i>=0;--i){
            boundry.add(temp.get(i));
        }
    }
    
    // bottom boundry
    static void addLeaves(Node node,List<Integer> boundry){
        if(isLeaf(node)){
            boundry.add(node.data);
            return;
        }
        if(node.left != null){
            addLeaves(node.left,boundry);
        }
        if(node.right != null){
            addLeaves(node.right,boundry);
        }
    }
    
    static List<Integer> displayBoundry(Node root){
        List<Integer> boundry = new ArrayList<>();
        if(root == null){
            return boundry;
        }
        if(!isLeaf(root)){
            boundry.add(root.data);
        }
        addLeftBoundry(root,boundry);
        addLeaves(root,boundry);
        addRightBoundry(root,boundry);
        return boundry;
    }

    public static void main(String[]args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        List<Integer> boundry = displayBoundry(root);
        
        for(int i : boundry){
            System.out.print(i+"  ");
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
