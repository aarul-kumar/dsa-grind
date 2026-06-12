class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public void backtrack(int nums[], ArrayList<Integer> l, boolean used[]) {
        if(l.size()==nums.length) {
            list.add(new ArrayList(l));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(used[i]) {
                continue;
            }
            l.add(nums[i]);
            used[i] = true;
            backtrack(nums, l, used);
            l.remove(l.size()-1);
            used[i] = false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        boolean used[] = new boolean[nums.length];
        backtrack(nums, new ArrayList(), used);
        return list;
    }
}