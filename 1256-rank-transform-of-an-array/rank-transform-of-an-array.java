class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int rank[] = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            rank[i] = arr[i];
        }
        Arrays.sort(rank);
        HashMap<Integer,Integer> hm = new HashMap<>();
        int count = 1;
        for(int i=0; i<rank.length; i++) {
            if(!hm.containsKey(rank[i])) {
                hm.put(rank[i],count);
                count++;
            }
        }
        for(int i=0; i<arr.length; i++) {
            arr[i] = hm.get(arr[i]);
        }
        return arr;
    }
}