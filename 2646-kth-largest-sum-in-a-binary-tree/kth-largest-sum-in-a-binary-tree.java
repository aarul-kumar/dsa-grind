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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(!q.isEmpty()) {
            int s = q.size();
            long sum = 0;
            for(int i=0; i<s; i++) {
                TreeNode curr = q.remove();
                sum += curr.val;
                if(curr.left!=null) {
                    q.add(curr.left);
                }
                if(curr.right!=null) {
                    q.add(curr.right);
                }
            }
            pq.add(sum);
        }
        if(pq.size()<k) {
            return -1;
        } else {
            long val = 0;
            for(int i=0; i<k; i++) {
                val = pq.remove();
            }
            return val;
        }
    }
}