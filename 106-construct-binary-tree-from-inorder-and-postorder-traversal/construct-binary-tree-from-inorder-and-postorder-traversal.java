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
    int posord[];
    HashMap<Integer, Integer> hm = new HashMap<>();
    int pos;
    public TreeNode revPostorder(int si, int ei) {
        if(si>ei) {
            return null;
        }

        TreeNode root = new TreeNode(posord[pos]);
        pos--;
        int idx = hm.get(root.val);

        root.right = revPostorder(idx+1,ei);
        root.left = revPostorder(si, idx-1);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        posord = postorder;
        pos = posord.length-1;

        for(int i=0; i<inorder.length; i++) {
            hm.put(inorder[i],i);
        }

        return revPostorder(0,inorder.length-1);
    }
}