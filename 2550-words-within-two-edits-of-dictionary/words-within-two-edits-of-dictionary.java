class Solution {
    private int diff(String s1, String s2) {
        int d = 0;
        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i)!=s2.charAt(i)) {
                d++;
            }
        }
        return d;
    }
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        int n = queries.length;
        int m = dictionary.length;
        List<String> l = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(diff(queries[i],dictionary[j])<=2) {
                    l.add(queries[i]);
                    j=m-1;
                }    
            }
        }
        return l;
    }
}