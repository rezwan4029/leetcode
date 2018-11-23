// https://leetcode.com/problems/count-primes/

class Solution {
    
    public int countPrimes(int n) {
        if(n < 3) return 0;
        int ans = 1;
        boolean notP [] = new boolean[n];
        for(int i = 3; i < n; i += 2) {
            if(!notP[i]) ans += 1;
            for(int j = i << 1 ; j < n ; j += i ) {
                notP[j] = true;
            }
        }
        return ans;
    }
}
