// https://leetcode.com/problems/sqrtx/

class Solution {
    public int mySqrt(int x) {
        int lo = 1, hi = x;
        while(lo <= hi) {
            int mid = (lo + hi) >> 1;
            int now = x / mid;
            if(now > mid) {
                lo = mid + 1;
            } else if(now < mid) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return hi;
    }
}
