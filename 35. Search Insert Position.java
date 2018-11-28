// https://leetcode.com/problems/search-insert-position/

class Solution {
    
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while(hi >= lo) {
            int mid = (lo + hi) >> 1;
            if(nums[mid] < target) {
                lo = mid + 1;
            }
            else if(nums[mid] > target) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
}
