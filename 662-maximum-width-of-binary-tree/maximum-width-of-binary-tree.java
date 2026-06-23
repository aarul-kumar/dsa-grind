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
    long ans = Long.MIN_VALUE;

    class Info {
        TreeNode node;
        long idx;
        Info(TreeNode node, long idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    public void solve(TreeNode root) {
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(root,0));

        while(!q.isEmpty()) {
            int s = q.size();
            long min = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;

            for(int i=0; i<s; i++) {
                Info curr = q.remove();
                min = Math.min(min, curr.idx);
                max = Math.max(max, curr.idx);
                ans = Math.max(ans, max-min+1);

                if(curr.node.left!=null) {
                    q.add(new Info(curr.node.left, (curr.idx)*2));
                }

                if(curr.node.right!=null) {
                    q.add(new Info(curr.node.right, 1+(curr.idx)*2));
                }
            }
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) {
            return 0;
        }
        solve(root);
        return (int) ans;
    }
}