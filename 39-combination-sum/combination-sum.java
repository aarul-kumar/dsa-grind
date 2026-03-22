class Solution {
    List<List<Integer>> list = new ArrayList<>();
    private void combSum(int cand[], int target, int start, List<Integer> temp) {
        if(target == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start; i<cand.length; i++) {
            if(cand[i]>target) {
                break;
            }
            temp.add(cand[i]);
            combSum(cand, target-cand[i], i, temp);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        combSum(candidates, target, 0, new ArrayList<>());
        return list;
    }
}