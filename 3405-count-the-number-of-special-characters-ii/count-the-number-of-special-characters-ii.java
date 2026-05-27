class Solution {
    public int numberOfSpecialChars(String word) {
        int ans=0;
        for(char ch='a'; ch<='z'; ch++) {
            if(word.contains(""+ch) && word.contains(""+Character.toUpperCase(ch))) {
                if(word.lastIndexOf(ch)<word.indexOf(Character.toUpperCase(ch))) {
                    ans++;
                }
            }
        }
        return ans;
    }
}