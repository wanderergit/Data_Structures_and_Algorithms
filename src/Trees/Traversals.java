package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

class ReverseLevelOrder{
    //print the last row first, then the second last row and so on.. from left to right itself
    //we can just put the right child first and then the left child in the output and then reverse the output..

    public void reverseLevelOrder(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Character> result = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode tn = queue.remove();
            if(tn.rightChild != null) queue.add(tn.rightChild);
            if(tn.leftChild != null) queue.add(tn.leftChild);
            result.add(tn.key);
        }
        System.out.print("The reverse level order traversal is : ");
        for(int i=result.size()-1; i>=0; i--){
            System.out.print(result.get(i)+", ");
        }
    }
}

class InorderRecursive {
    public void inorderRecursive(TreeNode root){
        if(root == null) return;
        inorderRecursive(root.leftChild);
        System.out.print(root.key+", ");
        inorderRecursive(root.rightChild);
    }
}

class InorderIterative {
    public void inorderIterative(TreeNode root){
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode current = root;
        boolean done = false;
        while(!done){
            if(current != null){
                st.push(current);
                current = current.leftChild;
            }
            else{
                if(!st.isEmpty()){
                    current = st.pop();
                    System.out.print(current.key+", ");
                    current = current.rightChild;
                } else done = true;
            }
        }
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
        ReverseLevelOrder rlo = new ReverseLevelOrder();
        rlo.reverseLevelOrder(a);
        System.out.println("\nInorder Recursive : ");
        InorderRecursive inorRec = new InorderRecursive();
        inorRec.inorderRecursive(a);
        System.out.println("\nInorder Iterative : ");
        InorderIterative inorIter = new InorderIterative();
        inorIter.inorderIterative(a);
    }
}

/*

            a
           / \
          b   c
         / \  /
        d   e f
       /
      g

 */
