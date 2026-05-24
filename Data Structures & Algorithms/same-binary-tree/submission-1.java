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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        stackP.push(p);
        stackQ.push(q);

        while(!stackP.isEmpty() && !stackQ.isEmpty())
        {
            TreeNode nodeP = stackP.pop();
            TreeNode nodeQ = stackQ.pop();

            if(nodeP == null && nodeQ == null) continue;
            if(nodeP == null || nodeQ == null) return false;
            if(nodeP.val != nodeQ.val) return false;

            stackP.push(nodeP.right);
            stackP.push(nodeP.left);
            stackQ.push(nodeQ.right);
            stackQ.push(nodeQ.left);
        }
        return stackP.isEmpty() && stackQ.isEmpty();
    }
}
