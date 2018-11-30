// https://leetcode.com/problems/arranging-coins

class Solution {
    
    public int arrangeCoins(int n) {
        int ans = 0;
        for(int pos = 1; n - pos >= 0 ; pos++) {
            n -= pos;
            ans++;
        }
        return ans;
    }
}
