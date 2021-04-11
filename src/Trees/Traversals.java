package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    char key;
    TreeNode leftChild;
    TreeNode rightChild;
    TreeNode(char key) {
        this.key = key;
        leftChild = null;
        rightChild = null;
    }
}

class LevelOrder{
    public void levelOrder(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Character> arr = new ArrayList<>();
        queue.add(root);
        //while queue is not empty, remove the first element and enqueue it's child(ren)
        while(queue.size() > 0){
            TreeNode tn = queue.remove();
            if(tn.leftChild != null){
                queue.add(tn.leftChild);
            }
            if (tn.rightChild != null){
                queue.add(tn.rightChild);
            }
            arr.add(tn.key);
        }
        System.out.println("The level order traversal is : " + arr.toString());
    }
}


public class Traversals {
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
        lo.levelOrder(a);
    }
}
