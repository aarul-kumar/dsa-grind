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
    List<List<Integer>> list = new ArrayList<>();

    public void sum(TreeNode root, int targetSum, int currSum, ArrayList<Integer> l){
        if(root==null){
            return;
        }
        l.add(root.val);
        currSum+=root.val;
        if(root.left==null && root.right==null){
            if(currSum==targetSum){
                list.add(new ArrayList(l));
            }
        }
        sum(root.left,targetSum,currSum,l);
        sum(root.right,targetSum,currSum,l);
        l.remove(l.size()-1);
        currSum-=root.val;
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> l =new ArrayList<>();
        sum(root,targetSum,0,l);
        return list;
    }
}