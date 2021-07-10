package Trees;

public class CheckIfIsomorphic {
    public static class Node {
        Node left, right;
        int data;
        Node(int data){
            this.data = data;
        }
    }
    public static void main(String[] args) {

    }
    boolean isIsomorphic(Node root1, Node root2) {
        if(root1 == null && root2 == null) return true;
        else if(root1 == null || root2 == null) return false;
        if(root1.data != root2.data) return false;
        // answer if children are not swapped
        boolean notSwapped = isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right);

        // answer if children are swapped
        boolean swapped = isIsomorphic(root1.right, root2.left) && isIsomorphic(root1.left, root2.right);

        return (swapped || notSwapped);
    }
}
