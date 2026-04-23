class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long arr[] = new long[n];
        HashMap<Integer, Long> indexSum = new HashMap<>();
        HashMap<Integer, Long> indexFreq = new HashMap<>();
        for(int i=0; i<n; i++) {
            if(indexFreq.containsKey(nums[i])) {
                long freq = indexFreq.get(nums[i]);
                long sum = indexSum.get(nums[i]);
                arr[i] += freq*i - sum;
                indexFreq.put(nums[i], freq+1);
                indexSum.put(nums[i], sum+i);
            } else {
                indexFreq.put(nums[i], 1L);
                indexSum.put(nums[i], (long) i);
            }
        }
        indexSum.clear();
        indexFreq.clear();
        for(int i=n-1; i>=0; i--) {
            if(indexFreq.containsKey(nums[i])) {
                long freq = indexFreq.get(nums[i]);
                long sum = indexSum.get(nums[i]);
                arr[i] += sum - freq*i;
                indexFreq.put(nums[i], freq+1);
                indexSum.put(nums[i], sum+i);
            } else {
                indexFreq.put(nums[i], 1L);
                indexSum.put(nums[i], (long) i);
            }
        }
        return arr;
    }
}