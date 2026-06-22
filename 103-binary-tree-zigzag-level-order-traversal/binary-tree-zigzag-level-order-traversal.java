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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null) {
            return list;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean ltor = true;

        while(!q.isEmpty()) {
            int s = q.size();
            LinkedList<Integer> l = new LinkedList<>();

            for(int i=0; i<s; i++) {
                TreeNode curr = q.remove();
                
                if(ltor) {
                    l.addLast(curr.val);
                } else {
                    l.addFirst(curr.val);
                }

                if(curr.left!=null) {
                    q.add(curr.left);
                }

                if(curr.right!=null) {
                    q.add(curr.right);
                }
            }

            list.add(l);
            ltor = !ltor;
        }

        return list;
    }
}