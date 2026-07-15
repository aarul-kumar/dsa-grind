class Solution {
    public int minDeletions(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int val:hm.values()) {
            arr.add(val);
        }
        arr.sort(Comparator.reverseOrder());
        HashSet<Integer> hs = new HashSet<>();
        int step = 0;
        for(int i=0; i<arr.size(); i++) {
            int curr = arr.get(i);
            while(hs.contains(curr) && curr>0) {
                curr--;
                step++;
            }
            hs.add(curr);
        }
        return step;
    }
}