// https://leetcode.com/problems/arranging-coins

class Solution {
    public int arrangeCoins(int n) {
        long lo = 1, hi = n;
        while(lo <= hi) {
            long mid = (lo + hi) / 2;
            long r = (mid * (mid + 1)) / 2;
            if(r > n) {
                hi = mid - 1;
            } else if(r == n) {
                return (int)mid;
            } else {
                lo = mid + 1;
            }
        }
        return (int)hi;
    }
}
