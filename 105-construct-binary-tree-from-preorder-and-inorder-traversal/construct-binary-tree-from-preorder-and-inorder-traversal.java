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
    int preord[];
    HashMap<Integer, Integer> hm = new HashMap<>();
    int pos = 0;
    public TreeNode buildPreorder(int si, int ei) {
        if(si>ei) {
            return null;
        }
        TreeNode root = new TreeNode(preord[pos]);
        pos++;
        int idx = hm.get(root.val);
        root.left = buildPreorder(si,idx-1);
        root.right = buildPreorder(idx+1,ei);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preord = preorder;
        int n = preorder.length;
        for(int i=0; i<n; i++) {
            hm.put(inorder[i],i);
        }
        return buildPreorder(0,n-1);
    }
}