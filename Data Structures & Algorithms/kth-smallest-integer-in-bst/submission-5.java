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
    private int count;
    private int answer;

    public int kthSmallest(TreeNode root, int k) {
        this.count = 0;
        this.answer = -1;
        inorder(root, k);
        return answer;

    }

    private void inorder(TreeNode node, int k)
    {
        if(node == null || count >= k)
        {
            return;
        }

        inorder(node.left, k);

        count++;
        if(count == k)
        {
            answer = node.val;
            return;
        }
        inorder(node.right , k);
    }
}
