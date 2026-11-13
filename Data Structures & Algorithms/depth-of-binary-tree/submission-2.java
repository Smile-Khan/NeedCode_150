/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        // Base case: if the current node is null, the depth contribution is 0
        if(root == null)
        {
            return 0;
        }

        // Recursively compute the depth of the left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // The max depth from this node is 1 (for the node itself) plus the maximum of its subtrees
        return Math.max(leftDepth, rightDepth)+1;
    }
}
