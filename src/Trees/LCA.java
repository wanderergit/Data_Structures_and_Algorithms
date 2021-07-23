package Trees;

public class LCA {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        // if given root is one of the values, return root
        if(root.val == p.val || root.val == q.val){
            return root;
        }

        TreeNode fromLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode fromRight = lowestCommonAncestor(root.right, p, q);

        // if it is present on either side of root, then root is lca
        if(fromLeft != null && fromRight != null)
            return root;

        // if any one side has both the nodes, then just propagate the ans
        return (fromLeft != null) ? fromLeft : fromRight;

    }
}
