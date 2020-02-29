// https://leetcode.com/problems/trapping-rain-water/

class Solution {
    public int trap(int[] h) {
        int n = h.length, ans = 0;
        if( n == 0) {
            return ans;
        }
        int l[] = new int[n];
        int r[] = new int[n];
        
        l[0] = h[0];
        for(int i = 1; i < n; i++) {
            l[i] = Math.max(l[i-1], h[i]);    
        }
        
        r[n - 1] = h[n -1];
        for(int i = n - 2; i >= 0; i--) {
            r[i] = Math.max(r[i+1], h[i]);
        }
        
        for(int i = 0; i < n; i++) {
            ans += (Math.min(l[i], r[i]) - h[i]);
        }
        
        return ans;
    }
}

https://assets.leetcode.com/uploads/2018/10/22/rainwatertrap.png
