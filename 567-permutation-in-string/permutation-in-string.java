class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<s1.length(); i++) {
            hm.put(s1.charAt(i), hm.getOrDefault(s1.charAt(i),0)+1);
        }
        for(int i=0; i<s2.length()-s1.length()+1; i++) {
            HashMap<Character, Integer> hm2 = new HashMap<>();
            for(int j=i; j<=i+s1.length()-1; j++) {
                hm2.put(s2.charAt(j), hm2.getOrDefault(s2.charAt(j),0)+1);
            }
            if(hm.equals(hm2)) {
                return true;
            }
        }
        return false;
    }
}