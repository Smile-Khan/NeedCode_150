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

    private int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int inStart, int inEnd)
    {
        if(inStart > inEnd) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = findIndex(inorder, rootVal, inStart, inEnd);

        root.left = build(preorder, inorder, inStart, inIndex - 1);
        root.right = build(preorder, inorder, inIndex + 1, inEnd);

        return root;
    }

    private int findIndex(int[] inorder, int target, int start, int end)
    {
        for(int i = start; i <= end; i++)
        {
            if(inorder[i] == target) return i;
        }
        return -1;
    }
}
