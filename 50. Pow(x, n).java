class Solution {
    public double myPow(double x, int n) {
        if(n == 0 ) return 1;
        if(n % 2 == 0) {
            double r = myPow(x, n/2);
            return r*r;
        } else {
            if( n < 0) {
                return (1/x) * myPow(x, n + 1);
            } else {
                return x * myPow(x, n - 1);
            }
        }
    }
}
