class Solution {
    public int maximumLengthSubstring(String s) {
        int arr[] = new int[26];
        int l = 0;
        int ans = 0;
        for(int r=0; r<s.length(); r++) {
            arr[s.charAt(r)-'a']++;
            while(arr[s.charAt(r)-'a']>2) {
                arr[s.charAt(l)-'a']--;
                l++;
            }
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}