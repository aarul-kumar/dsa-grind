class Solution {
    public boolean canBeEqual(String s1, String s2) {
        HashSet<Character> hs = new HashSet<>();
        for(int i=0; i<4; i++) {
            hs.add(s1.charAt(i));
        }
        for(int i=0; i<4; i++) {
            if(!hs.contains(s2.charAt(i))) {
                return false;
            }
        }
        HashSet<Character> hs2 = new HashSet<>();
        for(int i=0; i<4; i++) {
            hs2.add(s2.charAt(i));
        }
        if(hs.size() != hs2.size()) {
            return false;
        }
        if((s1.charAt(0)==s2.charAt(0) && s1.charAt(2)==s2.charAt(2)) || (s1.charAt(0)==s2.charAt(2) && s1.charAt(2)==s2.charAt(0))) {
            return true;
        } else {
            return false;
        }
    }
}