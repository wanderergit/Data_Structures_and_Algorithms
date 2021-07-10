package Trees;

/*
    https://www.geeksforgeeks.org/maximum-sum-nodes-binary-tree-no-two-adjacent/
    Given a binary tree with a value associated with each node,
    we need to choose a subset of these nodes such that the sum of chosen nodes is maximum under a
    constraint that no two chosen node in the subset should be directly connected that is,
    if we have taken a node in our sum then we can’t take any of its children in consideration
    and vice versa.
 */

public class MaxSumNonAdjacentNodes {
    public static class Node {
        Node left, right;
        int data;
        Node(int data){
            this.data = data;
        }
    }
    public static class Pair{
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args) {
        // the crux of the problem lies in the fact that if we choose a particular node, it's children cannot be chosen and vice versa
        // So our sum might come from selecting a particular node as well as not selecting a particular node
        // we need to maintain a couple of values (Pair) at every node where one value is the max sum including that node
        // and the other value is max sum coming from excluding that node
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.left.left = new Node(1);
        System.out.print(getMaxSum(root));
    }
    public static int getMaxSum(Node root) {
        Pair result = getMaxSumHelper(root);
        return Math.max(result.first, result.second);
    }
    public static Pair getMaxSumHelper(Node root){
        if(root == null){
            Pair currPair = new Pair(0, 0);
            return currPair;
        }
        Pair currPair = new Pair(0, 0);
        Pair leftPair = getMaxSumHelper(root.left);
        Pair rightPair = getMaxSumHelper(root.right);
        // when we chose the node, we add it's value and the value after not choosing children i.e. children.second
        // choosing curr node :
        currPair.first = leftPair.second + rightPair.second + root.data;
        // excluding curr node and chosing children max value:
        currPair.second = Math.max(leftPair.first, leftPair.second) + Math.max(rightPair.first, rightPair.second);
        return currPair;
    }
}
