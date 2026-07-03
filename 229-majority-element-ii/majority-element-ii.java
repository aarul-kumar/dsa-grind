class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        int ans1 = 0;
        int count2 = 0;
        int ans2 = 0;
        for(int i=0; i<nums.length; i++) {
            if(ans1==nums[i]) {
                count1++;
            } else if(ans2==nums[i]) {
                count2++;
            } else if(count1==0) {
                ans1 = nums[i];
                count1 = 1;
            } else if(count2==0) {
                ans2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==ans1) {
                count1++;
            } else if(nums[i]==ans2) {
                count2++;
            }
        }
        List<Integer> l = new ArrayList<>();
        if(count1>nums.length/3) {
            l.add(ans1);
        }
        if(count2>nums.length/3) {
            l.add(ans2);
        }
        return l;
    }
}