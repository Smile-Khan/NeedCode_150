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
        // If the interivewer asks for an iterative solution to avoid potential recursion stack overflows in unbalanced trees, you can use a queue:

        // Base case
        if(root == null)
        {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while(!queue.isEmpty())
        {
            int levelSize = queue.size();

            // Process all nodes at the current level
            for(int i = 0; i < levelSize; i++)
            {
                TreeNode curr = queue.poll();

                if(curr.left != null)
                {
                    queue.offer(curr.left);
                }
                if(curr.right != null)
                {
                    queue.offer(curr.right);
                }
            }
            // After processing a full level, increment depth
            depth++;
        }
        return depth;
    }
}
