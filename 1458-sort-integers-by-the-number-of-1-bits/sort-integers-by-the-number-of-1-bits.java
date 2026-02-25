class Solution {
    class Num implements Comparable<Num> {
        int numVal;
        int bitCount;

        Num(int numVal, int bitCount) {
            this.numVal = numVal;
            this.bitCount = bitCount;
        }

        @Override
        public int compareTo(Num other) {
            if(this.bitCount == other.bitCount) {
                return Integer.compare(this.numVal, other.numVal);
            }
            return Integer.compare(this.bitCount, other.bitCount);
        }
    }
    public int[] sortByBits(int[] arr) {
        PriorityQueue<Num> pq = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++) {
            pq.add(new Num(arr[i], Integer.bitCount(arr[i])));
        }
        int i=0;
        while(!pq.isEmpty()) {
            arr[i++] = pq.poll().numVal;
        }
        return arr;
    }
}