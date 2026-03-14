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
    boolean b = true;
    private void preorder(TreeNode root, int n) {
        if(root==null) {
            return;
        }
        if(root.val!=n) {
            b = false;
        }
        preorder(root.left, n);
        preorder(root.right, n);
    }
    public boolean isUnivalTree(TreeNode root) {
        preorder(root, root.val);
        if(b) {
            return true;
        } else {
            return false;
        }
    }
}