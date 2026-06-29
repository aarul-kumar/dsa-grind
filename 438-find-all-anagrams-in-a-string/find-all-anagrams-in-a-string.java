class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> l = new ArrayList<>();

        if(p.length()>s.length()) {
            return l;
        }

        HashMap<Character,Integer> hm1 = new HashMap<>();
        HashMap<Character,Integer> hm2 = new HashMap<>();

        for(int i=0; i<p.length(); i++) {
            hm1.put(p.charAt(i),hm1.getOrDefault(p.charAt(i),0)+1);
        }

        for(int i=0; i<s.length(); i++) {
            hm2.put(s.charAt(i),hm2.getOrDefault(s.charAt(i),0)+1);
            if(i>=p.length()) {
                char rem = s.charAt(i-p.length());
                hm2.put(rem,hm2.get(rem)-1);
                if(hm2.get(rem)==0) {
                    hm2.remove(rem);
                }
            }
            if(i>=p.length()-1) {
                if(hm1.equals(hm2)) {
                    l.add(i-p.length()+1);
                }
            }
        }
        return l;
    }
}