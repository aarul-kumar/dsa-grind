class Solution {
    HashMap<Character, String> hm = new HashMap<>();
    List<String> list = new ArrayList<>();
    public void backtrack(String digits, String ans, int idx) {
        if(ans.length()==digits.length()) {
            list.add(ans);
            return;
        }
        for(int i=0; i<hm.get(digits.charAt(idx)).length(); i++) {
            backtrack(digits, ans+hm.get(digits.charAt(idx)).charAt(i), idx+1);
        }
    }
    public List<String> letterCombinations(String digits) {
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");
        backtrack(digits, "", 0);
        return list;
    }
}