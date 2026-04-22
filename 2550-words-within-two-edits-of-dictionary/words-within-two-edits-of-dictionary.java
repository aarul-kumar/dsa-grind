class Solution {
    private int diff(String s1, String s2) {
        int d = 0;
        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i)!=s2.charAt(i)) {
                d++;
                if(d>2) {
                    return d;
                }
            }
        }
        return d;
    }
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> l = new ArrayList<>();
        for(String q : queries) {
            for(String d : dictionary) {
                if(diff(q,d)<=2) {
                    l.add(q);
                    break;
                }    
            }
        }
        return l;
    }
}