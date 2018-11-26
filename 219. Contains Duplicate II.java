// https://leetcode.com/problems/contains-duplicate-ii

class Solution {
    
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Map<Integer, Integer> seen = new HashMap<>();
        
        for(int i = 0 ; i < nums.length; i++) {
            Integer cur = seen.getOrDefault(nums[i], -1);
            if(cur != -1) {
                if(i + 1 - cur <= k) return true;
            }
            seen.put(nums[i], i + 1);
        }
        
        return false;
    }
    
}
