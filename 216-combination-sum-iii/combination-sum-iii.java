class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public void backtrack(int arr[], int k, int n, ArrayList<Integer> l, int idx, int currSum) {
        if(currSum == n && l.size() == k) {
            list.add(new ArrayList(l));
            return;
        }
        for(int i=idx; i<9; i++) {
            if(arr[i]+currSum <= n && l.size() < k) {
                l.add(arr[i]);
                backtrack(arr, k, n, l, i+1, currSum+arr[i]);
                l.remove(l.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        backtrack(arr, k, n, new ArrayList(), 0, 0);
        return list;
    }
}