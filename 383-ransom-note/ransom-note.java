class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> mapr = new HashMap<>();
        HashMap<Character, Integer> mapm = new HashMap<>();
        for(int i=0; i<ransomNote.length(); i++) {
            mapr.put(ransomNote.charAt(i), mapr.getOrDefault(ransomNote.charAt(i), 0)+1);
        }
        for(int i=0; i<magazine.length(); i++) {
            mapm.put(magazine.charAt(i), mapm.getOrDefault(magazine.charAt(i),0)+1);
        }
        for(Map.Entry<Character, Integer> entry:mapr.entrySet()) {
            if(mapm.getOrDefault(entry.getKey(),0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}