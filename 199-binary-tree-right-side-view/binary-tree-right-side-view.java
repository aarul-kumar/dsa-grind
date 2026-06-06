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
        TreeNode node;
        int vd;
        Info(TreeNode node, int vd){
            this.node=node;
            this.vd=vd;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, TreeNode> hm = new HashMap<>();
        List<Integer> l = new ArrayList<>();

        if(root==null) return l;

        int max=0;
        q.add(new Info(root, 0));
        q.add(null);

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                hm.put(curr.vd,curr.node);
                if(curr.node.left!=null){
                    q.add(new Info(curr.node.left,curr.vd+1));
                    max=Math.max(max,curr.vd+1);
                }
                if(curr.node.right!=null){
                    q.add(new Info(curr.node.right,curr.vd+1));
                    max=Math.max(max,curr.vd+1);
                }
            }
        }

        for(int i=0; i<=max; i++){
            l.add(hm.get(i).val);
        }

        return l;
    }
}