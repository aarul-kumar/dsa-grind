class Solution {
    public int wave(int num){
        String s = Integer.toString(num);
        int ans = 0;
        for(int i=1; i<s.length()-1; i++){
            char c = s.charAt(i);
            if((c<s.charAt(i-1) && c<s.charAt(i+1)) || (c>s.charAt(i-1) && c>s.charAt(i+1))) {
                ans++;
            }
        }
        return ans;
    }
    public int totalWaviness(int num1, int num2) {
        int ans = 0;
        for(int i=num1; i<=num2; i++){
            ans += wave(i);
        }
        return ans;
    }
}