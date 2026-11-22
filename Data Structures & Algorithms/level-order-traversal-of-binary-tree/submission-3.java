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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();

        if(root == null)
        {
            return levels;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty())
        {
            int levelSize = queue.size();

            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for(int idx = 0; idx < levelSize; idx++)
            {
                TreeNode current = queue.poll();
                currentLevel.add(current.val);

                if(current.left != null)

                {
                    queue.offer(current.left);
                }
                if(current.right != null)
                {
                    queue.offer(current.right);
                }
            }
            levels.add(currentLevel);
        }
        return levels;
    }
}
