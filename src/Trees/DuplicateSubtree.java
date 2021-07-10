package Trees;

import java.util.HashSet;

public class DuplicateSubtree {
    public static class Node {
        Node left, right;
        int data;
        Node(int data){
            this.data = data;
        }
    }
    public static void main(String[] args) {

    }
    HashSet<String> set = new HashSet<>();
    int result = 0;
    int dupSub(Node root) {
        helper(root);
        return result;
    }
    void helper(Node root){
        if(root == null) return;
        String str = "";
        if(root.left != null){
            str += root.left.data;
            helper(root.left);
        }
        str += root.data;
        if(root.right != null){
            str += root.right.data;
            helper(root.right);
        }
        if(str.length() > 2 && set.contains(str)){
            result = 1;
        }
        else set.add(str);
    }
}
