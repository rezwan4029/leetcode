// https://leetcode.com/problems/subsets/description/

class Solution {
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
}
