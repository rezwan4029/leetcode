// https://leetcode.com/problems/subsets/description/

class Solution {
    
    // Solution - 1 : Bitmask
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> Ans = new ArrayList<List<Integer>>();
        for(int mask = 0 ; mask < ( 1 << nums.length ); mask++ ){
            List<Integer> current = new ArrayList<Integer>();
            for(int i = 0 ; i < nums.length ; i++){
                if((mask & (1 << i)) != 0){
                    current.add(nums[i]);
                }
            }
            Ans.add(current);
        }
        return Ans;
    }
    
    // Solution - 2: Backtrack
    
    List<List<Integer>> ans;
    
    void solve(int pos, List<Integer> taken, int [] nums, int n) {
        if(pos == n) {
            ans.add(taken);
            return;
        }
        List<Integer> now = new ArrayList<>(taken);
        now.add(nums[pos]);
        solve(pos + 1, now, nums, n);
        solve(pos + 1, taken, nums, n);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        int n = nums.length;
        solve(0, new ArrayList<>(), nums, n);
        Collections.reverse(ans);
        return ans;
    }
}

