public class IdenticalTree{
    public static void main(String[]args){
        // Tree-1
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);

        // Tree-2
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        System.out.println(isIdentical(root1,root2));
    }
    /*
     * Following preorder all nodes should be same 
     */
    public static boolean isIdentical(Node node1,Node node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if (node1 == null || node2 == null){
            return false;
        }
        return (
            (node1.data == node2.data) &&
            isIdentical(node1.left,node2.left) &&
            isIdentical(node1.right,node2.right)
        );
    }
}

class Node {
    int data;
    Node left;
    Node right;
    public Node(int _data) {
        data = _data;
        left = null;
        right = null;
    }
}