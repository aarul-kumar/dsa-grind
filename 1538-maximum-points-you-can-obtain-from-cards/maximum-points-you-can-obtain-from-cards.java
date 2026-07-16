class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum = 0;
        for(int i=0; i<n; i++) {
            totalSum += cardPoints[i];
        }
        int currSum = 0;
        for(int i=0; i<n-k; i++) {
            currSum += cardPoints[i];
        }
        int min = currSum;
        int l = 0;
        for(int i=n-k; i<n; i++) {
            currSum += cardPoints[i];
            currSum -= cardPoints[l];
            l++;
            min = Math.min(min,currSum);
        }
        return totalSum-min;
    }
}