class Solution {
    
    List<List<Integer>> results;
    
    void rec(int[] nums, boolean[] taken, LinkedList<Integer> curr) {
        
        if(nums.length == curr.size()) {
            results.add(curr);
            return;
        }
        
        for(int i = 0 ; i < nums.length; i++) {
            if(taken[i]) continue;
            if(i > 0 && nums[i] == nums[i-1] && !taken[i-1]) continue;
            taken[i] = true;
            LinkedList<Integer> temp = new LinkedList<>(curr);
            temp.add(nums[i]);
            rec(nums, taken, temp);
            taken[i] = false;
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        results = new ArrayList<>();
        boolean taken [] = new boolean[nums.length];
        Arrays.sort(nums);
        rec(nums, taken, new LinkedList<>());
        return results;
    }
}
