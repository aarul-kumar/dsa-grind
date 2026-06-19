class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<>();

        for(int i=0; i<n; i++) {
            hs.add(nums[i]);
        }

        List<Integer> l = new ArrayList<>();

        for(int i=1; i<=n; i++) {
            if(!hs.contains(i)) {
                l.add(i);
            }
        }

        return l;
    }
}