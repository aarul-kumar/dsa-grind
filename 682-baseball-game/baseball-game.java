class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<operations.length; i++) {
            if(operations[i].equals("C")) {
                s.pop();
            }
            else if(operations[i].equals("D")) {
                s.push(2*s.peek());
            }
            else if(operations[i].equals("+")) {
                int val1 = s.pop();
                int val2 = s.pop();
                s.push(val2);
                s.push(val1);
                s.push(val1+val2);
            } else { 
                s.push(Integer.parseInt(operations[i]));
            }
        }
        int ans = 0;
        while(!s.isEmpty()) {
            ans += s.pop();
        }
        return ans;
    }
}