package Trees;

import Trees.MaxSubtreeSum.Node;

public class IsMirrorTrees {
    public static void main(String[] args) {
        Node root1 = new Node(2);
        Node root2 = new Node(2);

        root1.left = new Node(3);
        root2.right = new Node(3);

        root1.right = new Node(4);
        root2.left = new Node(4);

        root1.left.left = new Node(5);
        root2.right.right = new Node(5);

        System.out.println(isMirror(root1, root2));

    }

    static boolean isMirror(Node root1, Node root2){
        if(root1 == null && root2 == null){
            return true;
        } else if((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
            return false;
        }
        return (isMirror(root1.left, root2.right) &&
                isMirror(root1.right, root2.left) &&
                root1.data == root2.data);
    }
}
