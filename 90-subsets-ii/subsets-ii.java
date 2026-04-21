class Solution {
    private void subset(int nums[], List<Integer> l, List<List<Integer>> ans, int i) {
        if(i==nums.length) {
            ans.add(new ArrayList<>(l));
            return;
        }
        l.add(nums[i]);
        subset(nums, l, ans, i+1);

        l.remove(l.size()-1);
        int idx = i+1;
        while(idx<nums.length && nums[idx]==nums[idx-1]) {
            idx++;
        }
        subset(nums, l, ans, idx);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> l = new ArrayList<>();
        subset(nums, l, ans, 0);
        return ans;
    }
}