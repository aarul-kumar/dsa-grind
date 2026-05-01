class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        if(t.length()>n) {
            return "";
        }
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char ch : t.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }
        int req = t.length();
        int i=0, j=0;
        int size = Integer.MAX_VALUE;
        int startIdx = 0;
        while(j<n) {
            char ch = s.charAt(j);
            if(hm.containsKey(ch) && hm.get(ch) > 0) {
                req--;
            }
            hm.put(ch, hm.getOrDefault(ch, -1)-1);
            while(req==0) {
                int currSize = j-i+1;
                if(currSize<size) {
                    size = currSize;
                    startIdx = i;
                }
                hm.put(s.charAt(i), hm.get(s.charAt(i))+1);
                if(hm.get(s.charAt(i))>0) {
                    req++;
                }
                i++;
            }
            j++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx+size);
    }
}