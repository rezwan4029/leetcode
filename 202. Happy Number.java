// https://leetcode.com/problems/happy-number

class Solution {
    
    public boolean isHappy(int n) {
        HashMap<Integer, Boolean> vis = new HashMap<>();
        while(true) {
            if(n == 1) return true;
            if(vis.getOrDefault(n, false)) return false;
            vis.put(n, true);
            int now = n;
            int sum = 0;
            while(now > 0) {
                int x = now % 10;
                sum += (x * x);
                now /= 10;
            }
            n = sum;
        }
    }
}
