class Solution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        TreeSet<Integer> ts = new TreeSet<>();
        for(int i=0; i<nums.length; i++) {
            ts.add(nums[i]);
        }
        int arr[] = new int[hm.size()];
        int i = 0;
        for(int num:ts) {
            arr[i] = num;
            i++;
        }
        int val[] = new int[hm.size()];
        for(int j=0; j<arr.length; j++) {
            val[j] = hm.get(arr[j])*arr[j];
        }
        int dp[] = new int[arr.length+1];
        dp[0] = 0;
        dp[1] = val[0];
        for(int k=2; k<dp.length; k++) {
            if(arr[k-1]-1==arr[k-2]) {
                dp[k] = Math.max(dp[k-1], val[k-1]+dp[k-2]);
            } else {
                dp[k] = dp[k-1]+val[k-1];
            }
        }
        return dp[dp.length-1];
    }
}