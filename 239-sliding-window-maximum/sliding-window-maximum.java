class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<k; i++) {
            while(dq.size()>0 && nums[dq.peekLast()]<nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        for(int i=k; i<nums.length; i++) {
            arr.add(nums[dq.peekFirst()]);
            while(dq.size()>0 && dq.peekFirst()<=i-k) {
                dq.removeFirst();
            }
            while(dq.size()>0 && nums[dq.peekLast()]<nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        arr.add(nums[dq.peekFirst()]);
        int ans[] = new int[arr.size()];
        for(int i=0; i<arr.size(); i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }
}