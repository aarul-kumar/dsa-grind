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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> hm = new HashMap<>();
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<descriptions.length; i++){
            int par = descriptions[i][0];
            int child = descriptions[i][1];
            int isLeft = descriptions[i][2];

            hs.add(child);

            TreeNode node = hm.getOrDefault(par, new TreeNode(par));
            if(isLeft==1){
                node.left = hm.getOrDefault(child, new TreeNode(child));
                hm.put(child, node.left);
            } else {
                node.right = hm.getOrDefault(child, new TreeNode(child));
                hm.put(child, node.right);
            }

            hm.put(par, node);
        }

        int root=-1;
        for(int i=0; i<descriptions.length; i++){
            int par=descriptions[i][0];
            if(!hs.contains(par)){
                root=par;
                break;
            }
        }

        return hm.getOrDefault(root,null);
    }
}