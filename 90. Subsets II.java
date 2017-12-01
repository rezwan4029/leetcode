// https://leetcode.com/problems/subsets-ii/description/

class Solution {
    
    public void solve(int pos, int nums[], int len, LinkedList<Integer>current, List<List<Integer>> Ans){
        if(pos == len) {
            Ans.add(new ArrayList<>(current));
            current = new LinkedList<>();
            return;
        }
        
        current.add(nums[pos]);
        solve(pos+1, nums, len, current, Ans);
        current.removeLast();
        
        solve(pos+1, nums, len, current, Ans);
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> Ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        solve(0, nums, nums.length, new LinkedList<Integer>(), Ans);
        Ans = Ans.stream().distinct().collect(Collectors.toList());
        
        return Ans;
    }
     
}
