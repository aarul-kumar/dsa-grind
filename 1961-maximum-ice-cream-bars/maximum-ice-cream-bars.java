class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int count = 0;
        Arrays.sort(costs);
        int i = 0;
        while(coins>0 && i<costs.length) {
            if(coins>=costs[i]) {
                count++;
                coins = coins-costs[i];
            }
            i++;
        }
        return count;
    }
}