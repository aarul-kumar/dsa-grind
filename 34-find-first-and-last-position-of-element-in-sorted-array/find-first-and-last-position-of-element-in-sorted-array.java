class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int lefti = -1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(nums[mid] == target) {
                lefti = mid;
                end = mid-1;
            } else if(nums[mid]<target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        start = 0;
        end = nums.length-1;
        int righti = -1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(nums[mid] == target) {
                righti = mid;
                start = mid+1;
            } else if(nums[mid]>target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        int ans[] = {lefti, righti};
        return ans;
    }
}