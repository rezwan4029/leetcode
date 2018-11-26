// https://leetcode.com/problems/house-robber-ii/

class Solution {
    
    int solve(int pos, int n, int nums[], int dp[]) {
        if(pos >= n) return 0;
        if(dp[pos] != -1) return dp[pos];
        int ret = 0;
        ret = Math.max(ret, solve(pos + 2, n, nums, dp) + nums[pos]);
        ret = Math.max(ret, solve(pos + 1, n, nums, dp));
        return dp[pos] = ret;
    }
    
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        int ans1 = solve(1, n, nums, dp);
        Arrays.fill(dp, -1);
        int ans2 = solve(0, n - 1, nums, dp);
        return Math.max(ans1, ans2);
    }
    
}
