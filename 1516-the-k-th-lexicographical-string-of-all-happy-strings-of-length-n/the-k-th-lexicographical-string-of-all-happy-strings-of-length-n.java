class Solution {
    int count = 0;
    String result = "";
    private void solve(int n, StringBuilder curr, int k) {
        if(curr.length()==n) {
            count++;
            if(count==k) {
                result = curr.toString();
            }
            return;
        }
        for(char c='a'; c<='c'; c++) {
            if(curr.length()>0 && curr.charAt(curr.length()-1)==c) {
                continue;
            }
            curr.append(c);
            solve(n, curr, k);
            curr.deleteCharAt(curr.length()-1);
            if(!result.equals("")) {
                return;
            }
        }
    }
    public String getHappyString(int n, int k) {
        solve(n, new StringBuilder(), k);
        return result;
    }
}