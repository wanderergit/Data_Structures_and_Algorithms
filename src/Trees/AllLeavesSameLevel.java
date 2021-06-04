package Trees;

import Trees.MaxSubtreeSum.Node;

public class AllLeavesSameLevel {

    static boolean result;
    static int firstLeafLevel;
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(1);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(3);
;
        System.out.println(isAllLeavesSameLevel(root));
    }

    public static boolean isAllLeavesSameLevel(Node root){
        result = true;
        firstLeafLevel = -1;
        helper(root, 0);
        return result;
    }

    public static void helper(Node root, int level){
        // if leaf is found
        if(root.left == null && root.right == null){
            // if this is the first leaf to be found, set it's level to be the baseline to check other leaves
            if(firstLeafLevel  == -1){
                firstLeafLevel = level;
            } else {
                // check leaf level against first found leaf level
                if(firstLeafLevel != level){
                    result = false;
                }
            }
        }
        if(root.left != null)
            helper(root.left, level+1);
        if(root.right != null)
            helper(root.right, level+1);
    }

}
