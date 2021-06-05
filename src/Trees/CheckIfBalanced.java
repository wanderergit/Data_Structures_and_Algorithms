package Trees;

/*
A tree is balanced only if at every node, the difference of height of left subtree and height of right subtree is at most 1
 */

import Trees.MaxSubtreeSum.Node;

public class CheckIfBalanced {
    public static void main(String[] args) {
        Node root1 = new Node(2);
        root1.left = new Node(2);
        root1.left.left = new Node(2);
        root1.right = new Node(2);

        Node root2 = new Node(2);
        root2.left = new Node(2);
        root2.left.left = new Node(2);
        root2.left.left.left = new Node(2);
        root2.right = new Node(2);

        System.out.println(isBalanced(root1));
        System.out.println(isBalanced(root2));

    }
    static boolean result;
    static boolean isBalanced(Node root){
        result = true;
        getHeight(root);
        return result;
    }
    static int getHeight(Node root){
        if(root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1) result = false;

        return Math.max(leftHeight, rightHeight) + 1;
    }

}
