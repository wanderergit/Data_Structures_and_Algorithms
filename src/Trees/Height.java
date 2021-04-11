package Trees;

public class Height {
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
        System.out.println("The height of the tree is : " + getHeight(a));
        System.out.println("The height of the tree is : " + getHeight(b));
        System.out.println("The height of the tree is : " + getHeight(c));
        System.out.println("The height of the tree is : " + getHeight(d));
        System.out.println("The height of the tree is : " + getHeight(e));
    }

    public static int getHeight(TreeNode root){
        if(root == null) return 0;
        return Math.max(getHeight(root.leftChild), getHeight(root.rightChild)) + 1;
    }
}
