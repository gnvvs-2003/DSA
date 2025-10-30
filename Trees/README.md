# Introduction to trees
Trees are hierarchical organization
> node contains the key or value and reference to its child nodes 
Root node : Top most node of a tree 
Pefect binary tree
All the leaf nodes are at the same level i.e all the nodes have exactly 2 child nodes

For a perfectly balanced tree : 
height of left subtree = height of right sub tree = no of nodes between the leafnode and root node +1  = no of ancestors +1 


No of nodes  = n
=> height of tree = logn [to the base 2]

Degenerate tree : All sub nodes fall on a single side 

Balanced Binary Tree => max(abs(height of right sub tree - height of left sub tree)) = 1

# Traversal in binary Trees

For heirarchiel DS traversal is of 2 types
1. DFS : 
    Preorder : Root->Left->right
    Inorder : Left->root->right 
    Postorder : left->right->root
    
https://static.takeuforward.org/content/Screenshot%202024-01-07%20at%209.03.01%20PM-Dw3JnHQa

2. BFS : Level order

https://static.takeuforward.org/content/Screenshot%202024-01-08%20at%2010.24.34%20AM-wmqzwxiP

DFS uses recursion or stack to traverse 
BFS uses queue

Tree creation :
```
// Binary tree representation

// each node contains its data and references to child nodes

class Node {
    int nodeData;
    Node leftNode;
    Node rightNode;
    // root node 
    public Node(int value){
        nodeData = value;
        leftNode = null;
        rightNode = null;
    }
}

public class Main{
    public static void main (String[] args) {
        Node root = new Node(1); // root node left and right set to null
        // set left and right references 
        root.leftNode = new Node(2);
        root.rightNode = new Node(4);
        // node  = 2
        root.leftNode.leftNode = new Node(5);
    }
}
```

DFS : Preoreder 
```java
// Tree traversals

import java.util.*;

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

public class Main{
    /**
     * params : root node 
     * params : DS to store i.e stack as array
     */
    public static void preorder(Node root,List<Integer> array){
        // base case root node is null
        if(root == null){
            return;
        }
        array.add(root.data);
        System.out.println("Visited node : "+root.data);
        // left node traversals
        preorder(root.left,array);
        // right node traversals
        preorder(root.right,array);
    }
    
    public static List<Integer> preOrderTraversal(Node root){
        List<Integer> array = new ArrayList<>();
        preorder(root,array);
        return array;
    }
    
    public static void main(String[]args){
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        
        List<Integer> result = preOrderTraversal(root);
        // Displaying the preorder traversal result
        System.out.print("Preorder Traversal: ");
        
        for (int value:result){
            System.out.print(value+" ");
        }
    }
}
```

in order Traversal
```java
// Tree traversals

import java.util.*;

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

public class Main{
    /**
     * params : root node 
     * params : DS to store i.e stack as array
     */
    public static void inorder(Node root,List<Integer> array){
        // base case root node is null
        if(root == null){
            return;
        }
        // left node traversals
        inorder(root.left,array);
        array.add(root.data);
        System.out.println("Visited node : "+root.data);
        // right node traversals
        inorder(root.right,array);
    }
    
    public static List<Integer> inOrderTraversal(Node root){
        List<Integer> array = new ArrayList<>();
        inorder(root,array);
        return array;
    }
    
    public static void main(String[]args){
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        
        List<Integer> result = inOrderTraversal(root);
        // Displaying the preorder traversal result
        System.out.print("inorder Traversal: ");
        
        for (int value:result){
            System.out.print(value+" ");
        }
    }
}
```

using BFS

```java
// Tree traversals

import java.util.*;

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

public class Main{
    /**
     * params : root node 
     * Storage used are an array list(queue) and 2D table
     * loops each level add it to queue
     * add the queue to table 
     * loops until the queue is null i.e root as null
     */
    
    public static List<List<Integer>> levelOrder(Node root){
        List<List<Integer>> ans = new ArrayList<>();
        // base case 
        if (root==null){
            return ans;
        }
        // queue
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level  = new ArrayList<>();
            for (int i=0;i<size;i++){
                Node node = q.poll(); // 1st element in Queue
                level.add(node.data);
                // add child
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            // add to table
            ans.add(level);
        }
        return ans;
    }
    
    
    public static void main(String[]args){
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        
        List<List<Integer>> result = levelOrder(root);
        
        for(List<Integer> l1 : result){
            System.out.print("Level : ");
            for(int l2:l1){
                System.out.print(+l2+" ");
            }
            System.out.println();
        }
    }
}
```

Using 2 stacks DFS Postorder(left->right->root data)

```java
// Tree traversals

import java.util.*;

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

public class Main{
    
    public static List<Integer> postOrderUsingTwoStacks(Node root){
        List<Integer> postOrder = new ArrayList<>();
        // base case 
        if(root == null){
            return postOrder;
        }
        // 2 stacks
        Stack<Node> s1 = new Stack<>(); // current nodes 
        Stack<Node> s2 = new Stack<>(); // post order 
        
        s1.push(root);
        System.out.println(root.data + " is visited by s1");
        while(!s1.empty()){
            root = s1.pop();
            s2.push(root);
            System.out.println(root.data + " is visited by s2");
            if(root.left!=null){
                s1.push(root.left);
            }
            if(root.right!=null){
                s1.push(root.right);
            }
        }
        while(!s2.empty()){
            postOrder.add(s2.pop().data); // we are adding nodes not data so we should add `.data`
        }
        return postOrder;
    }
    
    
    public static void main(String[]args){
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        
        List<Integer> postOrderTraversal = postOrderUsingTwoStacks(root);
        
        for (int val:postOrderTraversal){
            System.out.print(val+" ");
        }
    }
}
```

Maximum height of Binary Tree

```java
import java.util.*;

/*
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
*/

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
```