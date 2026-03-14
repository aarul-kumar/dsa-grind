/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode t = new TreeNode(0);
    private void solve(TreeNode root, int n) {
        if(root==null) {
            return;
        }
        if(root.val==n) {
            t = root;
        }
        solve(root.left,n);
        solve(root.right,n);
    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        solve(cloned, target.val);
        return t;
    }
}