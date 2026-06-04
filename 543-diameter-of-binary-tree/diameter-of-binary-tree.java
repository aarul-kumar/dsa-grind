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
    class Info{
        int d;
        int h;
        Info(int d, int h){
            this.d=d;
            this.h=h;
        }
    }
    public Info diam(TreeNode root){
        if(root==null){
            return new Info(0,0);
        }
        Info lInfo=diam(root.left);
        Info rInfo=diam(root.right);
        int finalDiam = Math.max(Math.max(lInfo.d, rInfo.d),lInfo.h+rInfo.h+1);
        int finalht = Math.max(lInfo.h, rInfo.h)+1;
        return new Info(finalDiam, finalht);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        Info ans = diam(root);
        return ans.d-1;
    }
}