class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int prefix[] = new int[n];
        prefix[0] = nums[0];
        for(int i=1; i<n; i++) {
            prefix[i] = prefix[i-1]+nums[i];
        }
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int j=0; j<n; j++) {
            if(prefix[j]==k) {
                count++;
            }
            int val = prefix[j]-k;
            if(hm.containsKey(val)) {
                count += hm.get(val);
            }
            hm.put(prefix[j], hm.getOrDefault(prefix[j],0)+1);
        }
        return count;
    }
}