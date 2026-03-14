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
    List<String> list = new ArrayList<>();
    private void solve(TreeNode root, StringBuilder s) {
        if(root==null) {
            return;
        }
        int len = s.length();
        s.append(root.val);
        if(root.left==null && root.right==null) {
            list.add(s.toString());
        } else {
            s.append("->");
            solve(root.left, s);
            solve(root.right, s);
        }
        s.setLength(len);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        solve(root, new StringBuilder());
        return list;
    }
}