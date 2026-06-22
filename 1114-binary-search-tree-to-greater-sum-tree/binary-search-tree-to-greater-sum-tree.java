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
    int ans = 0;
    public void revInorder(TreeNode root) {
        if(root==null) {
            return;
        }
        revInorder(root.right);
        ans += root.val;
        root.val = ans;
        revInorder(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        revInorder(root);
        return root;
    }
}