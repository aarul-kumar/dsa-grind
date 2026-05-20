class Solution {
    class Pair implements Comparable<Pair> {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p) {
            return p.val-this.val;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int ans[] = new int[n-k+1];
        for(int i=0; i<k; i++) {
            pq.add(new Pair(nums[i],i));
        }
        ans[0] = pq.peek().val;
        for(int i=k; i<n; i++) {
            while(pq.size()>0 && pq.peek().idx<=(i-k)) {
                pq.remove();
            }
            pq.add(new Pair(nums[i],i));
            ans[i-k+1] = pq.peek().val;
        }
        return ans;
    }
}