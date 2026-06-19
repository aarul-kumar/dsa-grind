class Solution {
    public boolean wordPattern(String pattern, String s) {
        String words[] = s.split(" ");

        if(words.length != pattern.length()) {
            return false;
        }

        HashMap<Character, String> hm = new HashMap<>();
        HashMap<String, Character> hm2 = new HashMap<>();

        for(int i=0; i<pattern.length(); i++) {
            if(!hm.containsKey(pattern.charAt(i)) && !hm2.containsKey(words[i])) {
                hm.put(pattern.charAt(i), words[i]);
                hm2.put(words[i], pattern.charAt(i));
            } else {
                if(!words[i].equals(hm.get(pattern.charAt(i))) || hm2.get(words[i])!=pattern.charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }
}