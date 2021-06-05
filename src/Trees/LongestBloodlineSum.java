package Trees;

/*
    Given a binary tree of size N. Your task is to complete the function sumOfLongRootToLeafPath(), that find the sum of all nodes on the longest path from root to leaf node.
If two or more paths compete for the longest path, then the path having maximum sum of nodes is being considered.

Example 1:

Input:
        4
       / \
      2   5
     / \ / \
    7  1 2  3
      /
     6
Output: 13
Explanation:
        4
       / \
      2   5
     / \ / \
    7  1 2  3
      /
     6

The highlighted nodes (4, 2, 1, 6) above are
part of the longest root to leaf path having
sum = (4 + 2 + 1 + 6) = 13



 */

import Trees.MaxSubtreeSum.Node;

public class LongestBloodlineSum {
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(7);
        root.left.right = new Node(1);
        root.right.left = new Node(2);
        root.right.right = new Node(3);
        root.left.right.left = new Node(6);

        System.out.println(sumOfLongRootToLeafPath(root));

    }
    static int sumMax;
    static int maxDepth;
    public static int sumOfLongRootToLeafPath(Node root)
    {
        sumMax = 0;
        if(root == null) return sumMax;
        maxDepth = Integer.MIN_VALUE;
        helper(root, 0, 1);
        return sumMax;
    }
    public static void helper(Node root, int sumSoFar, int depth){
        sumSoFar += root.data;
        // if found leaf
        if(root.left == null && root.right == null){
            if(depth > maxDepth){
                maxDepth = depth;
                sumMax = sumSoFar;
            } else if(depth == maxDepth){
                sumMax = Math.max(sumMax, sumSoFar);
            }
            return;
        }
        // if not leaf
        if(root.left != null) helper(root.left, sumSoFar, depth+1);
        if(root.right != null) helper(root.right, sumSoFar, depth+1);
    }
}
