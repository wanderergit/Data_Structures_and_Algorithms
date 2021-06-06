package queues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class AllLevelAnagramTree {

    static class Node {
        Node left, right;
        int data;
        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {

        Node root1 = new Node(5);
        Node root2 = new Node(5);

        root1.left = new Node(3);
        root1.right = new Node(4);

        root2.left = new Node(4);
        root2.right = new Node(3);

        root1.left.left = new Node(1);
        root1.left.right = new Node(2);
        root1.right.left = new Node(6);

        root2.left.left = new Node(2);
        root2.right.left = new Node(1);
        root2.right.right = new Node(6);

        System.out.println(checkAllLevelAnagrams(root1, root2));

    }

    public static boolean checkAllLevelAnagrams(Node root1, Node root2){

        if(root1 == null || root2 == null) return false;

        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();
        queue1.add(root1);
        queue2.add(root2);

        while(queue1.size() > 0 && queue2.size() > 0){
           int m = queue1.size();
           int n = queue2.size();

           if(m != n) return false;
            ArrayList<Integer> arrayList1 = new ArrayList<>();
            ArrayList<Integer> arrayList2 = new ArrayList<>();

            for(int i=0; i<m; i++){
                Node tree1Node = queue1.remove();
                arrayList1.add(tree1Node.data);
                if(tree1Node.left != null) queue1.add(tree1Node.left);
                if(tree1Node.right != null) queue1.add(tree1Node.right);

                Node tree2Node = queue2.remove();
                arrayList2.add(tree2Node.data);
                if(tree2Node.left != null) queue2.add(tree2Node.left);
                if(tree2Node.right != null) queue2.add(tree2Node.right);
            }

            Collections.sort(arrayList1);
            Collections.sort(arrayList2);

            if(!arrayList1.equals(arrayList2))
                return false;

        }
        return true;
    }
}
