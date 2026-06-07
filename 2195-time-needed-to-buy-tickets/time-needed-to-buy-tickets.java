class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<tickets.length; i++){
            hm.put(i,tickets[i]);
            q.add(i);
        }
        int time=0;
        while(!q.isEmpty()){
            int currIdx = q.remove();
            hm.put(currIdx,hm.get(currIdx)-1);
            time++;
            if(currIdx==k){
                if(hm.get(currIdx)==0){
                    break;
                }
            }
            if(hm.get(currIdx)>0){
                q.add(currIdx);
            }
        }
        return time;
    }
}