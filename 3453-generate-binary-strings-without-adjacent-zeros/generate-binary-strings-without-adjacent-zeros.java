class Solution {
    List<String> list = new ArrayList<>();
    private void solve(int n, boolean lastZero, StringBuilder s) {
        if(s.length()==n) {
            list.add(s.toString());
            return;
        }
        if(!lastZero) {
            s.append("0");
            solve(n, true, s);
            s.deleteCharAt(s.length()-1);
        }
        s.append("1");
        solve(n, false, s);
        s.deleteCharAt(s.length()-1);
    }
    public List<String> validStrings(int n) {
        solve(n, false, new StringBuilder());
        return list;
    }
}