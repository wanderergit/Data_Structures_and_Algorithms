package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DiagonalTraversal {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }

    public ArrayList<Integer> diagonal(Node root)
    {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if(root == null) return res;
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.peek();
            while(curr != null){
                res.add(curr.data);
                if(curr.left != null)
                    q.add(curr.left);
                curr=curr.right;
            }
            q.remove();
        }
        return res;
    }
}
