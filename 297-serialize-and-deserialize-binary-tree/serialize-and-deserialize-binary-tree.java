/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        s(root, sb);
        return sb.toString();
    }
    public void s(TreeNode root, StringBuilder sb) {
        if(root==null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(",");
        s(root.left, sb);
        s(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String nodes[] = data.split(",");
        int index[] = {0};
        return ds(nodes, index);
    }
    public TreeNode ds(String nodes[], int index[]) {
        if(nodes[index[0]].equals("#")) {
            index[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[index[0]]));
        index[0]++;
        root.left = ds(nodes, index);
        root.right = ds(nodes, index);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));