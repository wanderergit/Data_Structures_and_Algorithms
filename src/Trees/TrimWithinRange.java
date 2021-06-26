package Trees;

public class TrimWithinRange {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        // handle the root
        if (root != null && (root.val < low || root.val > high)) {
            while (root != null && (root.val < low || root.val > high)) {
                if (root.val < low) root = root.right;
                else if (root.val > high) root = root.left;
            }
        }

        if (root == null) return root;

        // check left side
        if (root.left != null && root.left.val < low) {
            while (root.left != null && root.left.val < low) {
                root.left = root.left.right;
            }
        }
        if (root.left != null) {
            trimBST(root.left, low, high);
        }

        // check right side
        if (root.right != null && root.right.val > high) {
            while (root.right != null && root.right.val > high) {
                root.right = root.right.left;
            }
        }
        if (root.right != null) {
            trimBST(root.right, low, high);
        }
        return root;
    }
}
