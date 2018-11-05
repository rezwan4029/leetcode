// https://leetcode.com/problems/increasing-triplet-subsequence/

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length; i++) {
            if(a > nums[i]) a = nums[i];
            else if(b > nums[i] && nums[i] > a) b = nums[i];
            else if(c > nums[i] && nums[i] > b) {
                c = nums[i];
                return true;
            }
        }
        return false;
    }
}
