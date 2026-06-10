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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "[]";

        StringBuilder output = new StringBuilder();
        output.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if(node == null)
            {
                output.append("null,");
            }
            else
            {
                output.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        // Remove trailing comma and close bracket
        output.setLength(output.length() - 1);
        output.append("]");
        return output.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;

        String[] values = data.substring(1, data.length() - 1).split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);

        int i = 1;
        while(!queue.isEmpty() && i < values.length)
        {
            TreeNode node = queue.poll();

            // Left child
            if(!values[i].equals("null"))
            {
                node.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(node.left);
            }
            i++;

            // Right child
            if(i < values.length && !values[i].equals("null"))
            {
                node.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
     }
}
