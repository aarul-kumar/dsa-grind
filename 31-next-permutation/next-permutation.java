class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        for(int i=nums.length-2; i>=0; i--) {
            if(nums[i]<nums[i+1]) {
                pivot = i;
                break;
            }
        }
        if(pivot == -1) {
            Arrays.sort(nums);
            return;
        }
        for(int i=nums.length-1; i>pivot; i--) {
            if(nums[pivot]<nums[i]) {
                int temp = nums[pivot];
                nums[pivot] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        int i = pivot+1;
        int j = nums.length-1;
        while(i<j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}