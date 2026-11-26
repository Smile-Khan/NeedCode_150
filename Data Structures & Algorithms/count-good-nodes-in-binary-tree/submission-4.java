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
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;

        int count = 0;
        // Queue of {node, maxSoFar} pairs
        Deque<Object[]> queue = new ArrayDeque<>();
        queue.offer(new Object[]{root, Integer.MIN_VALUE});

        while(!queue.isEmpty())
        {
            Object[] pair = queue.poll();
            TreeNode node = (TreeNode) pair[0];
            int maxSoFar = (int) pair[1];

            if(node.val >= maxSoFar)
            {
                count++;
            }
            int newMax = Math.max(maxSoFar, node.val);

            if(node.left != null) queue.offer(new Object[]{node.left, newMax});
            if(node.right != null) queue.offer(new Object[]{node.right, newMax});
        }
        return count;
    }
}
