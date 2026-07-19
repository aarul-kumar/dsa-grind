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
    class Info {
        int min;
        int max;
        Info(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
    int ans = 0;
    public Info minMax(TreeNode root) {
        if(root==null) {
            return new Info(Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info left = minMax(root.left);
        Info right = minMax(root.right);
        if(root.left!=null) {
            ans = Math.max(ans, Math.max(Math.abs(root.val-left.min),Math.abs(root.val-left.max)));
        }
        if(root.right!=null) {
            ans = Math.max(ans, Math.max(Math.abs(root.val-right.min), Math.abs(root.val-right.max)));
        }
        return new Info(Math.min(root.val,Math.min(left.min,right.min)),Math.max(root.val,Math.max(left.max,right.max)));
    }
    public int maxAncestorDiff(TreeNode root) {
        minMax(root);
        return ans;
    }
}