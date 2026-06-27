class Solution {
    class Pair implements Comparable<Pair> {
        char ch;
        int freq;
        Pair(char ch, int freq) {
            this.ch=ch;
            this.freq=freq;
        }
        @Override
        public int compareTo(Pair p) {
            return p.freq-this.freq;
        }
    }
    public String reorganizeString(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char ch=s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        for(Map.Entry<Character,Integer> entry:hm.entrySet()) {
            pq.add(new Pair(entry.getKey(),entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while(pq.size()>=2) {
            Pair p1 = pq.remove();
            Pair p2 = pq.remove();
            sb.append(p1.ch);
            sb.append(p2.ch);
            p1.freq--;
            p2.freq--;
            if(p1.freq>0) pq.add(p1);
            if(p2.freq>0) pq.add(p2);
        }
        if(!pq.isEmpty()) {
            Pair p = pq.remove();
            if(p.freq>1) return "";
            sb.append(p.ch);
        }
        return sb.toString();
    }
}