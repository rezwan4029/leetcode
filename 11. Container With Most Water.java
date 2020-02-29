// https://leetcode.com/problems/container-with-most-water/

class Solution {
 
    public int maxArea(int[] h) {
        int ans = 0, n = h.length;
        int l = 0, r = n - 1;
        while(l < r) {
            ans = Math.max(ans, Math.min(h[l], h[r]) * (r - l));
            if(h[l] < h[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
