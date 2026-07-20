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
    int count = 0;
    public void solve(TreeNode root, String s) {
        if(root==null) {
            return;
        }
        if(root.left==null && root.right==null) {
            s += root.val;
            count += Integer.parseInt(s);
            return;
        }
        solve(root.left, s+root.val);
        solve(root.right, s+root.val);
    }
    public int sumNumbers(TreeNode root) {
        if(root==null) {
            return count;
        }
        solve(root, "");
        return count;
    }
}