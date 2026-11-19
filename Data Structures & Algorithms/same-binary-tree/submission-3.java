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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Both null -> same
        if(p == null && q == null) return true;

        // One null, other not -> different structure
        if(p == null || q == null) return false;

        // Values differ -> not same
        if(p.val != q.val) return false;

        // Check subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
