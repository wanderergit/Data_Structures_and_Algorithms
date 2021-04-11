package Trees;

public class Diameter {
    public static void main(String[] args) {
        TreeNode a = new TreeNode('a');
        TreeNode b = new TreeNode('b');
        TreeNode c = new TreeNode('c');
        TreeNode d = new TreeNode('d');
        TreeNode e = new TreeNode('e');
        TreeNode f = new TreeNode('f');
        TreeNode g = new TreeNode('g');
        a.leftChild = b;
        a.rightChild = c;
        b.leftChild = d;
        b.rightChild = e;
        c.leftChild = f;
        d.leftChild = g;
        getDiameter(a);
        System.out.println("Diameter of the tree : " + max);
    }
    static int max = Integer.MIN_VALUE;
    public static int getDiameter(TreeNode root){
        if(root == null) return 0;
        int leftSum = getDiameter(root.leftChild);
        int rightSum = getDiameter(root.rightChild);
        max = Math.max(max, leftSum+rightSum+1);
        return Math.max(leftSum,rightSum)+1;
    }
}
