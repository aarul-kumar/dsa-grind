class Solution {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int arr[] = new int[nums.length];
        for(int i=0, j=0; i<=nums.length-1; i++, j++) {
            arr[j] = nums[i+1];
            arr[++j] = nums[i++];
        }
        return arr;
    }
}