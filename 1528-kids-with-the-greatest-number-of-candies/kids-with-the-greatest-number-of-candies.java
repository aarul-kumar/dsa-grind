class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        int n = candies.length;
        for(int i=0; i<n; i++) {
            if(candies[i]>max) {
                max = candies[i];
            }
        }
        List<Boolean> b = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(candies[i]+extraCandies>=max) {
                b.add(true);
            } else {
                b.add(false);
            }
        }
        return b;
    }
}