

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder output = new StringBuilder();
        serializeHelper(root, output);
        return output.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder output) {
        if (node == null) {
            output.append("null,");  
            return;
        }
        output.append(node.val).append(",");
        serializeHelper(node.left, output);
        serializeHelper(node.right, output);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);  
    }
    
    private TreeNode deserializeHelper(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("null")) return null;
        
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        return node;
    }
}