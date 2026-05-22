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

    class Pair {
        int height;
        
        boolean balanced;
        Pair(int height, boolean balanced)
        {
            this.height = height;
            this.balanced = balanced;
        }
    }
    public boolean isBalanced(TreeNode root) {
        return dfs(root).balanced;
    }
    private Pair dfs(TreeNode node)
    {
        if(node == null) return new Pair(0, true);

        Pair left = dfs(node.left);
        Pair right = dfs(node.right);

        boolean balanced = left.balanced && right.balanced 
            && Math.abs(left.height - right.height) <= 1;
            
            int height = Math.max(left.height, right.height) + 1;

            return new Pair(height, balanced);
    }
}
