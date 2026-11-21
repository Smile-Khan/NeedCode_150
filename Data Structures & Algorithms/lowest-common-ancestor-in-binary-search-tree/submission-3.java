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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        
        while (current != null) {
            if (p.val < current.val && q.val < current.val) {
                // Both nodes are in the left subtree
                current = current.left;
            } else if (p.val > current.val && q.val > current.val) {
                // Both nodes are in the right subtree
                current = current.right;
            } else {
                // Found the split point (or one node equals current) — this is the LCA
                return current;
            }
        }
        
        return null; // Should never reach here given constraints
    }
}