class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> small = new ArrayList<>();
        ArrayList<Integer> large = new ArrayList<>();
        int count=0;
        for(int i:nums){
            if(i<pivot){
                small.add(i);
            }else if(i>pivot){
                large.add(i);
            }else{
                count++;
            }
        }
        int s = small.size();
        for(int i=0; i<s; i++){
            nums[i]=small.get(i);
        }
        for(int i=0; i<count; i++){
            nums[s++]=pivot;
        }
        int l = large.size();
        for(int i=0; i<l; i++){
            nums[s++]=large.get(i);
        }
        return nums;
    }
}