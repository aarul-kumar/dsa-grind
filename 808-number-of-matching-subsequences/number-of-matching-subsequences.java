class Solution {
    class Node {
        String word;
        int i;
        Node(String word, int i) {
            this.word=word;
            this.i=i;
        }
    }
    public int numMatchingSubseq(String s, String[] words) {
        ArrayList<Node> arr[]=new ArrayList[26];
        for(int i=0; i<26; i++) {
            arr[i] = new ArrayList<>();
        }
        for(String word:words) {
            arr[word.charAt(0)-'a'].add(new Node(word,0));
        }
        int ans = 0;
        for(char ch:s.toCharArray()) {
            ArrayList<Node> curr = arr[ch-'a'];
            arr[ch-'a'] = new ArrayList<>();
            for(Node n:curr) {
                n.i++;
                if(n.i==n.word.length()) {
                    ans++;
                } else {
                    char next = n.word.charAt(n.i);
                    arr[next-'a'].add(n);
                }
            }
        }
        return ans;
    }
}