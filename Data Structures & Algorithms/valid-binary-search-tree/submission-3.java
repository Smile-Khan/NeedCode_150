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
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean validate(TreeNode node, long minBound, long maxBound)
    {
        if(node == null)
        {
            return true;
        }

        if(node.val <= minBound || node.val >= maxBound)
        {
            return false;
        }

        boolean leftValid = validate(node.left, minBound, node.val);
        boolean rightValid = validate(node.right, node.val, maxBound);

        return leftValid && rightValid;
    }
}
