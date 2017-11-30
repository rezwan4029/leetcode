// https://leetcode.com/problems/combination-sum/description/

class Solution {
    
    
    void solve(int[] candidates, int pos, int currSum, LinkedList<Integer> currBucket, int target, List<List<Integer>> ans) {
        
        if(pos == candidates.length){
            return;
        }
        if(currSum == target) {
            if(!currBucket.isEmpty()){
                ans.add(new ArrayList<Integer>(currBucket));
                currBucket = new LinkedList<Integer>();
            }
        }
        if(candidates[pos] + currSum <= target){
            currBucket.add(candidates[pos]);
            solve(candidates, pos, candidates[pos] + currSum, currBucket, target, ans);
            currBucket.removeLast();
        }
        solve(candidates, pos + 1, currSum, currBucket, target, ans);
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates.length == 0 ){
            return res;
        }
        Arrays.sort(candidates);
        if(candidates[0] > target ){
            return res;
        }
        solve(candidates, 0, 0, new LinkedList<Integer>(), target, res);
        return res;
    }
}
