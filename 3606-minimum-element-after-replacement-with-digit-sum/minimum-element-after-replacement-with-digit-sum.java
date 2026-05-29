class Solution {
    private int calcSum(int n) {
        int sum = 0;
        while(n > 0) {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
    public int minElement(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            int sum = calcSum(nums[i]);
            if(minSum > sum) {
                minSum = sum;
            }
        }
        return minSum;
    }
}