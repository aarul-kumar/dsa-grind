class Solution {
    class Info implements Comparable<Info> {
        Character ch;
        int freq;
        Info(Character ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
        @Override
        public int compareTo(Info i) {
            return i.freq-this.freq;
        }
    }
    public String frequencySort(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(!hm.containsKey(ch)) {
                hm.put(ch,1);
            } else {
                hm.put(ch, hm.get(ch)+1);
            }
        }
        PriorityQueue<Info> pq = new PriorityQueue<>();
        for(Map.Entry<Character, Integer> entry : hm.entrySet()) {
            pq.add(new Info(entry.getKey(), entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Info curr = pq.remove();
            Character c = curr.ch;
            int f = curr.freq;
            while(f>0) {
                sb.append(c);
                f--;
            }
        }
        return sb.toString();
    }
}