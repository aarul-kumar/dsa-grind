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
    public TreeNode lca(TreeNode root, int n1, int n2) {
        if(root==null || root.val==n1 || root.val==n2) {
            return root;
        }
        TreeNode leftLca = lca(root.left, n1, n2);
        TreeNode rightLca = lca(root.right, n1, n2);
        if(leftLca==null) {
            return rightLca;
        }
        if(rightLca==null) {
            return leftLca;
        }
        return root;
    }
    public boolean path(TreeNode lca, int n, StringBuilder sb) {
        if(lca==null) {
            return false;
        }
        if(lca.val==n) {
            return true;
        }
        sb.append("L");
        if(path(lca.left, n, sb)) {
            return true;
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("R");
        if(path(lca.right, n, sb)) {
            return true;
        }
        sb.deleteCharAt(sb.length()-1);
        return false;
    } 
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = lca(root, startValue, destValue);
        StringBuilder start = new StringBuilder();
        path(lca, startValue, start);
        StringBuilder dest = new StringBuilder();
        path(lca, destValue, dest);
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<start.length(); i++) {
            ans.append("U");
        }
        ans.append(dest);
        return ans.toString();
    }
}