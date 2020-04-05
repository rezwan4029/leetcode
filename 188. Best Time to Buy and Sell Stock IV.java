// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

class Solution {

    public int solve(int day, int trade, int canBuy, int prices[], int dp[][][]) {
        if(day >= prices.length || trade <= 0) {
            return 0;
        }
        
        if(dp[day][trade][canBuy] != -1) {
            return dp[day][trade][canBuy];
        }
        
        int ret = solve(day + 1, trade, canBuy, prices, dp);
        
        if(canBuy == 1) {
            ret = Math.max(ret, solve(day + 1, trade, 0, prices, dp) - prices[day]);
        } else {
            ret = Math.max(ret, solve(day + 1, trade - 1, 1, prices, dp) + prices[day]); 
        }
        
        return dp[day][trade][canBuy] = ret;
        
    }
    
    public int maxProfit(int k, int[] prices) {
        
        if( prices.length < 2) {
            return 0;
        }
        
        if(k > prices.length / 2) {
            return greedyMaxProfit(prices);
        }
        
        int dp[][][] = new int[prices.length][k + 1][2];
        
        for(int x = 0; x < prices.length; x++)
            for(int y = 0; y <= k; y++)
                dp[x][y][0] = dp[x][y][1] = -1;
        
        return solve(0, k, 1, prices, dp);
    }
    
    int greedyMaxProfit(int[] prices) {
        int ans = 0;
        for(int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            ans += profit > 0 ? profit : 0;
        }
        return ans;
    }
    
}
