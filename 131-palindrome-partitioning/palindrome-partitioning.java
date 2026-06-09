class Solution {
    public boolean isPalindrome(String s){
        int i=0, j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
    List<List<String>> list = new ArrayList<>();
    public void solve(int idx, String s, ArrayList<String> l) {
        if(idx==s.length()){
            list.add(new ArrayList(l));
            return;
        }
        for(int i=idx; i<s.length(); i++){
            String curr = s.substring(idx,i+1);
            if(isPalindrome(curr)){
                l.add(curr);
                solve(i+1,s,l);
                l.remove(l.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        solve(0,s,new ArrayList<>());
        return list;
    }
}