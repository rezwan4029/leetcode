// https://leetcode.com/problems/combination-sum-ii/description/

class Solution {
    
    public void solve(int[] candidates, int pos, int currentSum, int target, LinkedList<Integer>currentBucket, List<List<Integer>> Ans){
        
        if(currentSum == target){
            if(!currentBucket.isEmpty()){
                Ans.add(new ArrayList<>(currentBucket));
            }
            currentBucket = new LinkedList<Integer>();
        }
        
        if(pos == candidates.length){
            currentBucket = new LinkedList<Integer>();
            return;
        }
        
        if(candidates[pos] + currentSum <= target){
            currentBucket.add(candidates[pos]);
            solve(candidates, pos + 1, candidates[pos] + currentSum, target, currentBucket, Ans);
            currentBucket.removeLast();
        }
        solve(candidates, pos + 1, currentSum, target, currentBucket, Ans);
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> Ans = new ArrayList<List<Integer>>();
        if(candidates.length == 0 ){
            return Ans;
        }
        Arrays.sort(candidates);
        if(candidates[0] > target){
            return Ans;
        }
        solve(candidates, 0, 0, target, new LinkedList<Integer>(), Ans);
        Ans = Ans.stream().distinct().collect(Collectors.toList());
        return Ans;
    }
    
}
