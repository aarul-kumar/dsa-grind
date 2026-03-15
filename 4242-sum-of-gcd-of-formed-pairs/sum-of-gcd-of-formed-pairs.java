class Solution {
    private int gcd(int a, int b) {
        if(b==0) {
            return a;
        }
        return gcd(b, a%b);
    }
    public long gcdSum(int[] nums) {
        int prefixGcd[] = new int[nums.length];
        int max = 0;
        for (int i=0; i<nums.length; i++) {
            max = Math.max(max, nums[i]);
            prefixGcd[i] = gcd(nums[i], max);
        }
        Arrays.sort(prefixGcd);
        int i=0;
        int j=nums.length-1;
        long sum = 0;
        while(i<j) {
            sum += gcd(prefixGcd[i], prefixGcd[j]);
            i++;
            j--;
        }
        return sum;
    }
}