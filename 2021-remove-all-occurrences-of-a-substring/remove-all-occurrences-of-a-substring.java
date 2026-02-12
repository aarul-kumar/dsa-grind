class Solution {
    public String removeOccurrences(String s, String part) {
        if(part.length()>s.length()) {
            return s;
        }
        int index = s.indexOf(part);
        int l = part.length();
        while(index != -1) {
            s = s.substring(0, index) + s.substring(index+l);
            index = s.indexOf(part);
        }
        return s;
    }
}