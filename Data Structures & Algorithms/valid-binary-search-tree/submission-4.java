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
    public boolean isValidBST(TreeNode root) {
        // Use long bounds to safely handle Integer.MIN_VALUE and Integer.MAX_VALUE edge cases
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean validate(TreeNode node, long minBound, long maxBound)
    {
        // Base case: an empty subtree is a valid BST
        if(node == null)
        {
            return true;
        }

        // Strict inequality: BSTs do not allow duplicate values
        if(node.val <= minBound || node.val >= maxBound)
        {
            return false;
        }


        // Left subtree values must be strictly less than current node's value
        // Right subtree values must be strictly greater than current node's value
        return validate(node.left, minBound, node.val) &&
        validate(node.right, node.val, maxBound);
    }
}
