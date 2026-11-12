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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) 
        {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty())
        {
            TreeNode curr = queue.poll();

            // Swap the left and right children of the current node
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;


            // Add non-null children to the queue for processing
            if(curr.left != null)
            {
                queue.offer(curr.left);
            }

            if(curr.right != null)
            {
                queue.offer(curr.right);
            }
        }
        return root;
    }
}
