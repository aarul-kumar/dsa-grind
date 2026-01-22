class Solution {
    public int minimumPairRemoval(int[] nums) {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for(int i:nums) {
            list.add(i);
        }
        while(!checkOrder(list)) {
            int minIdx = -1;
            int sum = Integer.MAX_VALUE;
            for(int i=1; i<list.size(); i++) {
                int currSum = list.get(i)+list.get(i-1);
                if(currSum<sum) {
                    sum = currSum;
                    minIdx = i-1;
                }
            }
            if(minIdx != -1) {
                list.remove(minIdx+1);
                list.set(minIdx, sum);
                count++;
            }
        }
        return count;
    }
    boolean checkOrder(List<Integer> list) {
        for(int i=1; i<list.size(); i++) {
            if(list.get(i)<list.get(i-1)) {
                return false;
            }
        }
        return true;
    }
}