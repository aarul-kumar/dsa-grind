class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> l = new ArrayList<>();
        for(int i=0; i<nums.length-2; i++) {
            if(i>0 && nums[i]==nums[i-1]) {
                continue;
            }
            int lp = i+1;
            int rp = nums.length-1;
            while(lp<rp) {
                if(nums[i]+nums[lp]+nums[rp]==0) {
                    l.add(Arrays.asList(nums[i],nums[lp],nums[rp]));
                    lp++;
                    rp--;
                    while(lp<rp && nums[lp]==nums[lp-1]) {
                        lp++;
                    }
                    while(lp<rp && nums[rp]==nums[rp+1]) {
                        rp--;
                    }
                } else if(nums[i]+nums[lp]+nums[rp]>0) {
                    rp--;
                } else {
                    lp++;
                }
            }
        }
        return l;
    }
}