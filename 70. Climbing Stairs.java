// https://leetcode.com/problems/climbing-stairs/description/

class Solution {
    
    public int climbStairs(int n) {
        int dp[] = new int[n+2];
        for(int i = 0 ; i <= n ; i++ ) dp[i] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3 ; i <= n ; i++) {
            dp[i] += (dp[i-1] + dp[i-2]);
        }
        return dp[n];
    }
    
}
