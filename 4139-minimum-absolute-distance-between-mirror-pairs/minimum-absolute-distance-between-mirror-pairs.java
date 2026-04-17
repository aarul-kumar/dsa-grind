class Solution {
    private int getRev(int n) {
            int rev = 0;
            while(n>0) {
                int rem = n%10;
                rev = rev*10 + rem;
                n /= 10;
            }
            return rev;
        }
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            if(hm.containsKey(nums[i])) {
                ans = Math.min(ans, i-hm.get(nums[i]));
            }
            hm.put(getRev(nums[i]),i);
        }
        return ans != Integer.MAX_VALUE ? ans : -1;
    }
}