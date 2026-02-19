class Solution {
    public int countBinarySubstrings(String s) {
        int ans = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            int count = 1;
            while(i<s.length()-1 && s.charAt(i)==s.charAt(i+1)) {
                count++;
                i++;
            }
            arr.add(count);
        }
        for(int i=0; i<arr.size()-1; i++) {
            ans += Math.min(arr.get(i), arr.get(i+1));
        }
        return ans;
    }
}