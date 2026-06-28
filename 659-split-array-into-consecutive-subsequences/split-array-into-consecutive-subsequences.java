class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
        }
        HashMap<Integer,Integer> req = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(freq.get(nums[i])==0) {
                continue;
            }
            if(req.containsKey(nums[i]) && req.get(nums[i])>0) {
                freq.put(nums[i],freq.get(nums[i])-1);
                req.put(nums[i]+1,req.getOrDefault(nums[i]+1,0)+1);
                req.put(nums[i],req.get(nums[i])-1);
            } else if(freq.getOrDefault(nums[i]+1,0)>0 && freq.getOrDefault(nums[i]+2,0)>0) {
                req.put(nums[i]+3,req.getOrDefault(nums[i]+3,0)+1);
                freq.put(nums[i],freq.get(nums[i])-1);
                freq.put(nums[i]+1,freq.get(nums[i]+1)-1);
                freq.put(nums[i]+2,freq.get(nums[i]+2)-1);
            } else {
                return false;
            }
        }
        return true;
    }
}