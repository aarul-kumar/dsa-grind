class Solution {
    class Row implements Comparable<Row> {
        int soldiers;
        int idx;

        Row(int soldiers, int idx) {
            this.soldiers=soldiers;
            this.idx=idx;
        }

        @Override
        public int compareTo(Row r) {
            if(this.soldiers==r.soldiers) {
                return this.idx-r.idx;
            } else {
                return this.soldiers-r.soldiers;
            }
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Row> pq = new PriorityQueue<>();
        for(int i=0; i<mat.length; i++) {
            int count = 0;
            for(int j=0; j<mat[0].length; j++) {
                count += mat[i][j];
            }
            pq.add(new Row(count, i));
        }
        int arr[] = new int[k];
        for(int i=0; i<k; i++) {
            arr[i] = pq.remove().idx;
        }
        return arr;
    }
}