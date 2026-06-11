class Solution {
    List<String> list = new ArrayList<>();
    public void solve(int open, int close, int n, String curr) {
        if(curr.length()==2*n) {
            list.add(curr);
            return;
        }
        if(open < n) {
            solve(open+1, close, n, curr+"(");
        }
        if(close<open) {
            solve(open, close+1, n, curr+")");
        }
    }
    public List<String> generateParenthesis(int n) {
        solve(0,0,n,"");
        return list;
    }
}