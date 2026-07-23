class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for(int i=0; i<apple.length; i++) {
            sum += apple[i];
        }
        Arrays.sort(capacity);
        int ans = 0;
        int cap = 0;
        for(int i=capacity.length-1; i>=0; i--) {
            cap +=  capacity[i];
            ans++;
            if(cap>=sum) {
                return ans;
            }
        }
        return ans;
    }
}