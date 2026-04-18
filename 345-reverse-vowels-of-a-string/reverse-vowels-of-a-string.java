class Solution {
    public String reverseVowels(String s) {
        ArrayList<Character> arr = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u' || s.charAt(i)=='A' || s.charAt(i)=='E' || s.charAt(i)=='I' || s.charAt(i)=='O' || s.charAt(i)=='U') {
                arr.add(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        int n = arr.size()-1;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u' || s.charAt(i)=='A' || s.charAt(i)=='E' || s.charAt(i)=='I' || s.charAt(i)=='O' || s.charAt(i)=='U') {
                sb.append(arr.get(n));
                n--;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}