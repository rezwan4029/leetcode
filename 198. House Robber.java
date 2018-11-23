// https://leetcode.com/problems/house-robber/

class Solution {
    
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        int [] dp = new int[n + 2];
        for(int i = n - 1 ; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[0];    
    }
    
}
