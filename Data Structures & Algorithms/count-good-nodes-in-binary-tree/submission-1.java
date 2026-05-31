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

    class Pair{
        TreeNode node;
        int maxVal;
        Pair(TreeNode node, int maxVal)
        {
            this.node = node;
            this.maxVal = maxVal;
        }
    }
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;

        int result = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, Integer.MIN_VALUE));
        
        while(!queue.isEmpty())
        {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int maxVal = pair.maxVal;

            if(node.val >= maxVal)
            {
                result++;
                maxVal = node.val;
            }

            if(node.left != null)
            {
                queue.offer(new Pair(node.left, Math.max(maxVal, node.val)));
            }

            if(node.right != null)
            {
                queue.offer(new Pair(node.right, Math.max(maxVal, node.val)));
            }
        }
        return result;
    }
}
