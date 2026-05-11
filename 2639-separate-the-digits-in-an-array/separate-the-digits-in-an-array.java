class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            int number = nums[i];
            if(number<10) {
                arr.add(number);
            } else {
                Stack<Integer> s = new Stack<>();
                while(number>0) {
                    s.push(number%10);
                    number /= 10;
                }
                while(!s.isEmpty()) {
                    arr.add(s.pop());
                }
            }
        }
        int ans[] = new int[arr.size()];
        for(int i=0; i<arr.size(); i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }
}