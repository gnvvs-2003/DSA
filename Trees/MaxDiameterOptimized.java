// Node class for the binary tree
class Node {
    int data;
    Node left;
    Node right;

    Node(int _data) {
        data = _data;
        left = null;
        right = null;
    }
}

public class MaxDiameterOptimized {
    // Global diameter variable wrapped in an array for mutability
    static int[] diameter = new int[1]; // Initialized to 0 by default

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        System.out.println("Diameter (edges): " + getMaxDiameter(root));
    }

    // Function to compute height and update diameter
    public static int height(Node root, int[] diameter) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left, diameter);
        int rightHeight = height(root.right, diameter);

        // Update diameter as the sum of left and right subtree heights
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Wrapper to get the diameter
    public static int getMaxDiameter(Node root) {
        height(root, diameter);
        return diameter[0];
    }
}
