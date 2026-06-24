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
    ArrayList<Integer> l = new ArrayList<>();
    public void inorder(TreeNode root) {
        if(root==null) {
            return;
        }
        inorder(root.left);
        l.add(root.val);
        inorder(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<l.size()-1; i++) {
            ans = Math.min(ans,l.get(i+1)-l.get(i));
        }
        return ans;
    }
}