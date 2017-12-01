// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

class Solution {
    
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int current = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[current] != nums[i]) {
                current++;
                nums[current] = nums[i];
            }
        }
        return current + 1;
    }
    
}
