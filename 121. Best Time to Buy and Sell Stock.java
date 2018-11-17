// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution {
    
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0 || n == 1) return 0;
        int sell[] = new int[n];
        int buy[] =  new int[n];
        buy[0] = prices[0];
        for(int i = 1 ; i < n ; i++) {
            buy[i] = Math.min(prices[i], buy[i-1]);
        }
        sell[n-1] = prices[n-1];
        for(int i = n - 2; i >= 0 ; i--) {
            sell[i] = Math.max(prices[i], sell[i+1]);
        }
        int ans = 0;
        for(int i = 0 ; i < n ; i++) {
            ans = Math.max(sell[i] - buy[i], ans);
        }
        return ans;
    }
}
