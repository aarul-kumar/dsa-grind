class Solution {
    String ans = "";
    HashSet<String> set = new HashSet<>();

    private boolean checkAns(String s) {
        if(!set.contains(s)) {
            ans = s;
            return true;
        }
        return false;
    }

    private boolean binString(int n, String s) {
        if(n == 0) {
            return checkAns(s);
        }

        if(binString(n-1, s+"0")) return true;
        if(binString(n-1, s+"1")) return true;

        return false;
    }

    public String findDifferentBinaryString(String[] nums) {
        for(String num : nums) {
            set.add(num);
        }

        binString(nums.length, "");
        return ans;
    }
}