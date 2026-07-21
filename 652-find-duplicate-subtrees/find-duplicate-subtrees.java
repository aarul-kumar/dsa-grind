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
    HashMap<String, Integer> hm = new HashMap<>();
    List<TreeNode> list = new ArrayList<>();
    public String serialize(TreeNode root) {
        if(root==null) {
            return "#";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        String s = root.val+","+left+","+right;
        hm.put(s,hm.getOrDefault(s,0)+1);
        if(hm.get(s)==2) {
            list.add(root);
        }
        return s;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return list;
    }
}