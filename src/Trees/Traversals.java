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

class PreorderRecursive {
    public void preorderRecursive(TreeNode root){
        if(root == null) return;
        System.out.print(root.key+", ");
        preorderRecursive(root.leftChild);
        preorderRecursive(root.rightChild);
    }
}

class PreorderIterative {
    public void preorderIterative(TreeNode root){
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode current = root;
        boolean done = false;
        while(!done){
            if(current != null){
                System.out.print(current.key+", ");
                st.push(current);
                current = current.leftChild;
            }
            else{
                if(!st.isEmpty()){
                    current = st.pop();
                    current = current.rightChild;
                } else done = true;
            }
        }
    }
}

class PostorderRecursive {
    public void postorderRecursive(TreeNode root){
        if(root == null)return;
        postorderRecursive(root.leftChild);
        postorderRecursive(root.rightChild);
        System.out.print(root.key+", ");
    }
}

class PostorderIterative {
    public void postorderIterative(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        TreeNode current = root;

    }
}

class LeftView {
    public void leftView(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode delim = new TreeNode('|');
        queue.add(delim);
        queue.add(root);
        while(queue.size() > 1){
            if(queue.peek().key == '|'){
                queue.remove();
                TreeNode tn = queue.remove();
                System.out.print(tn.key+", ");
                queue.add(delim);
                if(tn.leftChild != null) queue.add(tn.leftChild);
                if(tn.rightChild != null) queue.add(tn.rightChild);
            } else {
                TreeNode tn = queue.remove();
                if(tn.leftChild != null) queue.add(tn.leftChild);
                if(tn.rightChild != null) queue.add(tn.rightChild);
            }
        }
    }
}

class RightView {
    public void rightView(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode delim = new TreeNode('|');
        queue.add(root);
        queue.add(delim);
        TreeNode tn = null;
        while(queue.size() > 1){
            if(queue.peek().key == '|'){
                queue.remove();
                System.out.print(tn.key+", ");
                queue.add(delim);
            } else {
                tn = queue.remove();
                if(tn.leftChild != null) queue.add(tn.leftChild);
                if(tn.rightChild != null) queue.add(tn.rightChild);
            }
        }
        System.out.print(tn.key+", ");
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
        TreeNode h = new TreeNode('h');
        TreeNode i = new TreeNode('i');
        TreeNode j = new TreeNode('j');
        TreeNode k = new TreeNode('k');
        TreeNode l = new TreeNode('l');
        a.leftChild = b;
        a.rightChild = c;
        b.leftChild = d;
        b.rightChild = e;
        c.leftChild = f;
        d.leftChild = g;
        f.leftChild = h;
        f.rightChild = i;
        h.leftChild = j;
        h.rightChild = k;
        j.leftChild = l;
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
        System.out.println("\nPreorder Recursive : ");
        PreorderRecursive preorRec = new PreorderRecursive();
        preorRec.preorderRecursive(a);
        System.out.println("\nPreorder Iterative : ");
        PreorderIterative preorIter = new PreorderIterative();
        preorIter.preorderIterative(a);
        System.out.println("\nPostorder Recursive : ");
        PostorderRecursive postorRec = new PostorderRecursive();
        postorRec.postorderRecursive(a);
        System.out.println("\nPostorder Iterative : ");
        PostorderIterative postordIter = new PostorderIterative();
        postordIter.postorderIterative(a);
        System.out.println("\nLeft View : ");
        LeftView lv = new LeftView();
        lv.leftView(a);
        System.out.println("\nRight View : ");
        RightView rv = new RightView();
        rv.rightView(a);
    }
}

/*

            a
           / \
          b   c
         / \  /
        d   e f
       /     / \
      g     h   i
           / \
          j   k
         /
        l

 */
