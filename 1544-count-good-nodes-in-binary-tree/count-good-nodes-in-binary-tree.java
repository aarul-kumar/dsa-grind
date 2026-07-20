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
    public void solve(TreeNode root, int currMax) {
        if(root==null) {
            return;
        }
        if(root.val>=currMax) {
            count++;
        }
        solve(root.left, Math.max(root.val, currMax));
        solve(root.right, Math.max(root.val, currMax));
    }
    public int goodNodes(TreeNode root) {
        if(root==null) {
            return count;
        }
        solve(root, root.val);
        return count;
    }
}