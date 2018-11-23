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
    
    
    public int countPrimes(int n) {
        boolean prime [] = new boolean[n];
        for(int i = 0 ; i < n ; i++) prime[i] = true;
        int ans = 0;
        int sq = (int)Math.sqrt(n) + 1;
        for(int i = 2; i < sq ; i++) {
            if(!prime[i]) continue;
            for(int j = i << 1 ; j < n ; j += i ) {
                prime[j] = false;
            }
        }
        for(int i = 2; i < n ; i++) ans += (prime[i] ? 1 : 0);
        return ans;
    }
    
}
