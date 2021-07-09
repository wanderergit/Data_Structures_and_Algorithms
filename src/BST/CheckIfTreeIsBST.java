package BST;

public class CheckIfTreeIsBST {
    static class Node{
        Node left, right;
        int data;
        Node(int data){
            this.data = data;
        }
    }
    public static void main(String[] args) {

    }
    static boolean isBST(Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }
    static boolean isBSTUtil(Node root, int min, int max){
        if(root == null) return true;
        if(root.data < min || root.data > max)
            return false;

        return (isBSTUtil(root.left, min, root.data-1) &&
                isBSTUtil(root.right, root.data+1, max));
    }
}
