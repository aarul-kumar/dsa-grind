class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long arr[] = new long[n];
        HashMap<Integer, Long> sum = new HashMap<>();
        HashMap<Integer, Long> freq = new HashMap<>();
        for(int i=0; i<n; i++) {
            long f = freq.getOrDefault(nums[i], 0L);
            long s = sum.getOrDefault(nums[i], 0L);
            arr[i] += f*i-s;
            freq.put(nums[i], f+1);
            sum.put(nums[i], s+i);
        }
        sum.clear();
        freq.clear();
        for(int i=n-1; i>=0; i--) {
            long f = freq.getOrDefault(nums[i], 0L);
            long s = sum.getOrDefault(nums[i], 0L);
            arr[i] += s-f*i;
            freq.put(nums[i], f+1);
            sum.put(nums[i], s+i);
        }
        return arr;
    }
}