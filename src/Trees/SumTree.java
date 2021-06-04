package Trees;

import Trees.MaxSubtreeSum.Node;
/*
    To paste in GFG
 */
public class SumTree {

    public static void main(String[] args) {
        Node root = new Node(26);
        root.left = new Node(10);
        root.right = new Node(3);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(3);

        System.out.println(isSumTree(root));
    }
    static boolean result;
    static boolean isSumTree(Node root){
        result = true;
        isSumTreeHelper(root);
        return result;
    }
    static int isSumTreeHelper(Node root){
        if(root == null) return 0;

        int sumFromLeft = isSumTreeHelper(root.left);
        int sumFromRight = isSumTreeHelper(root.right);
        if(sumFromLeft == 0 && sumFromRight == 0){
            return root.data;
        }
        else if(sumFromLeft + sumFromRight != root.data){
            result = false;
        }
        return sumFromLeft + sumFromRight + root.data;
    }
}
