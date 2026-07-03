class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int n:nums) {
            hs.add(n);
        }
        int max = 0;
        for(int n:hs) {
            if(!hs.contains(n-1)) {
                int count = 1;
                int x = n;
                while(hs.contains(x+1)) {
                    x++;
                    count++;
                }
                max = Math.max(max,count);
            }
        }
        return max;
    }
}