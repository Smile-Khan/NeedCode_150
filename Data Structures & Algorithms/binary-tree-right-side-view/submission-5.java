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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        collectRightView(root, 0, view);
        return view;
    }
    private void collectRightView(TreeNode node, int depth, List<Integer> view)
    {
        if(node == null)
        {
            return;
        }

        if(depth == view.size())
        {
            view.add(node.val);
        }
        // Visit right child first so the first node seen at each depth is the rightmost
        collectRightView(node.right, depth + 1, view);
        collectRightView(node.left, depth + 1, view);
    }
}
