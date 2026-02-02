class Solution {
    class Pair {
        int val;
        int idx;
        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        Comparator<Pair> cmp = (a,b) -> {
            if(a.val == b.val) {
                return a.idx - b.idx;
            }
            return a.val-b.val;
        };
        TreeSet<Pair> kMin = new TreeSet<>(cmp);
        TreeSet<Pair> rem = new TreeSet<>(cmp);
        long sum = 0;
        int i = 1;
        while(i-dist<1) {
            kMin.add(new Pair(nums[i],i));
            sum += nums[i];
            if(kMin.size()>k-1) {
                Pair temp = kMin.pollLast();
                sum -= temp.val;
                rem.add(temp);
            }
            i++;
        }
        long ans = Long.MAX_VALUE;
        while(i<n) {
            kMin.add(new Pair(nums[i],i));
            sum += nums[i];
            if(kMin.size()>k-1) {
                Pair temp = kMin.pollLast();
                sum -= temp.val;
                rem.add(temp);
            }
            ans = Math.min(ans,sum);
            Pair removed = new Pair(nums[i-dist],i-dist);
            if(kMin.remove(removed)) {
                sum -= removed.val;
                if(!rem.isEmpty()) {
                    Pair added = rem.pollFirst();
                    kMin.add(added);
                    sum += added.val;
                }
            } else {
                rem.remove(removed);
            }
            i++;
        }
        return nums[0]+ans;
    }
}