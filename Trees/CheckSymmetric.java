class CheckSymmetric{
    public static boolean isSymmetric(Node root){
        // if root is null
        if(root == null){
            return true;
        }
        return isSymmetricUtil(root.left,root.right);
    }
    
    public static boolean isSymmetricUtil(Node leftChild,Node rightChild){
        if(leftChild == null || rightChild == null){
            return leftChild == rightChild;
        }
        return 
            (leftChild.data == rightChild.data) &&
            isSymmetricUtil(leftChild.left,rightChild.right) &&
            isSymmetricUtil(leftChild.right,rightChild.left);
    }
    
    public static void main(String[]args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        System.out.println(isSymmetric(root));
    }
}

class Node {
    int data;
    Node left;
    Node right;

    // Constructor to initialize
    // the node with a value
    public Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}