class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int n:nums) {
            min = Math.min(n, min);
            max = Math.max(n, max);
            hs.add(n);
        }
        List<Integer> l = new ArrayList<>();
        for(int i=min; i<=max; i++) {
            if(!hs.contains(i)) {
                l.add(i);
            }
        }
        return l;
    }
}