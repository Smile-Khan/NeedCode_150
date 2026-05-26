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
        if(root == null) return null;

        // Both nodes are smaller -> go left
        if(p.val < root.val && q.val < root.val)
        {
            return lowestCommonAncestor(root.left, p, q);
        }

        // Both nodes are larger -> go right
        else if(p.val > root.val && q.val > root.val)
        {
            return lowestCommonAncestor(root.right, p, q);
        }
        else
        {
            // One on each side (or equal) -> current root is LCA
            return root;
        }
    }
}
