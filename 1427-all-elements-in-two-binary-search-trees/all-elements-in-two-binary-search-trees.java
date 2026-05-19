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
    private void inorder(TreeNode root, ArrayList<Integer> arr) {
        if(root==null) {
            return;
        }
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }
    private List<Integer> merge(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        int i1=0;
        int i2=0;
        int n1=arr1.size();
        int n2=arr2.size();
        List<Integer> list = new ArrayList<>();
        while(i1<n1 && i2<n2) {
            if(arr1.get(i1)<arr2.get(i2)) {
                list.add(arr1.get(i1));
                i1++;
            } else {
                list.add(arr2.get(i2));
                i2++;
            }
        }
        while(i1<n1) {
            list.add(arr1.get(i1));
            i1++;
        }
        while(i2<n2) {
            list.add(arr2.get(i2));
            i2++;
        }
        return list;
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        inorder(root1, arr1);
        inorder(root2, arr2);
        return merge(arr1, arr2);
    }
}