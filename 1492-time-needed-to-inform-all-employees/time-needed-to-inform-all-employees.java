class Solution {
    public int dfs(int emp, List<List<Integer>> tree, int informTime[]) {
        int max = 0;
        for(int i:tree.get(emp)) {
            max = Math.max(max, dfs(i, tree, informTime));
        }
        return informTime[emp]+max;
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> tree = new ArrayList<>();
        for(int i=0; i<n; i++) {
            tree.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++) {
            int m = manager[i];
            if(m!=-1) {
                tree.get(m).add(i);
            }
        }
        return dfs(headID, tree, informTime);
    }
}