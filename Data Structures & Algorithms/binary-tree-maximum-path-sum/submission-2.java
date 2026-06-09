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
        int maxPath;
        int maxSum;
        Pair(int maxPath, int maxSum)
        {
            this.maxPath = maxPath;
            this.maxSum = maxSum;
        }
    }
    public int maxPathSum(TreeNode root)
    {
        return dfs(root).maxSum;
    }
    private Pair dfs(TreeNode node)
    {
        if(node == null) return new Pair(0, Integer.MIN_VALUE);

        Pair left = dfs(node.left);
        Pair right = dfs(node.right);

        int maxPath = node.val + Math.max(0, Math.max(left.maxPath, right.maxPath));

        int maxSum = Math.max(
            Math.max(left.maxSum, right.maxSum), node.val + Math.max(0, left.maxPath) + 
            Math.max(0, right.maxPath)
        );

        return new Pair(maxPath, maxSum);
    }
}
