// https://leetcode.com/problems/unique-paths/

class Solution {
    public int uniquePaths(int m, int n) {
        
        int g[][] = new int[m][n];
        
        for(int i = m - 1; i >= 0; i--)
            for(int j = n - 1; j >= 0; j--) {
                if(i + 1 < m && j + 1 < n) {
                    g[i][j] += (g[i + 1][j] + g[i][j + 1]);
                } else if(i + 1 < m) {
                     g[i][j] += g[i + 1][j];
                } else if(j + 1 < n) {
                     g[i][j] += g[i][j + 1];
                } else {
                    g[i][j] = 1;
                }
            }
        return g[0][0];
    }
}
