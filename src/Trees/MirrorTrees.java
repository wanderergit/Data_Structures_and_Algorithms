package Trees;

public class MirrorTrees {
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
        LevelOrder lo = new LevelOrder();
        TreeNode res = getMirrorTree(a);
        System.out.println("Original Tree");
        lo.levelOrder(a);
        System.out.println("Mirror Tree");
        lo.levelOrder(res);
    }

    public static TreeNode getMirrorTree(TreeNode original){
        if(original == null) return original;
        TreeNode mirrorRoot = new TreeNode(original.key);
        mirrorRoot.leftChild = getMirrorTree(original.rightChild);
        mirrorRoot.rightChild = getMirrorTree(original.leftChild);
        return mirrorRoot;
    }
}
