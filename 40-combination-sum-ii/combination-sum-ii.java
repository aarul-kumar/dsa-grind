class Solution {
    List<List<Integer>> list = new ArrayList<>();
    private void combSum(int cand[], int target, int start, List<Integer> temp) {
        if(target == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start; i<cand.length; i++) {
            if(i>start && cand[i]==cand[i-1]) {
                continue;
            }
            if(cand[i]>target) {
                break;
            }
            temp.add(cand[i]);
            combSum(cand, target-cand[i], i+1, temp);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<Integer> arr = new ArrayList<>();
        Arrays.sort(candidates);
        combSum(candidates, target, 0, arr);
        return list;
    }
}