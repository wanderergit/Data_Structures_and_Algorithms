package Trees;

public class BTFromBracketString {
    static void preOrder(Node node) {
        if (node == null)
            return;
        System.out.printf("%d ", node.data);
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void main(String[] args) {
        Node root = constructBinaryTreeFromString("1(2)(3)");
        preOrder(root);
    }
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }


    static Node constructBinaryTreeFromString(String s) {
        String rootStr = s.substring(0, 1);
        int data = Integer.parseInt(rootStr);
        Node currNode = new Node(data);
        String remaining = s.substring(1);
        if(remaining.length() > 0){
            int ptr = 1;
            int count = 1;
            int endLeft = 0;
            while(ptr < remaining.length()){
                if(remaining.charAt(ptr) == '('){
                    count++;
                } else if (remaining.charAt(ptr) == ')'){
                    count--;
                }
                if(count == 0){
                    endLeft = ptr;
                    break;
                }
                ptr++;
            }
            currNode.left = constructBinaryTreeFromString(remaining.substring(1, endLeft));
            currNode.right = constructBinaryTreeFromString(remaining.substring(endLeft + 2, remaining.length()-1));
        }
        return currNode;
    }
}
