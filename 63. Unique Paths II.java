// https://leetcode.com/problems/unique-paths-ii/


class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int g[][] = new int[m][n];
        g[m - 1][n - 1] = 1;
        
        for(int i = m - 1; i >= 0; i--)
            for(int j = n - 1; j >= 0; j--) {
                if(i + 1 < m && j + 1 < n && obstacleGrid[i + 1][j] == 0 && obstacleGrid[i][j + 1] == 0) {
                    g[i][j] += (g[i + 1][j] + g[i][j + 1]);
                } else if(i + 1 < m && obstacleGrid[i + 1][j] == 0) {
                     g[i][j] += g[i + 1][j];
                } else if(j + 1 < n && obstacleGrid[i][j + 1] == 0) {
                     g[i][j] += g[i][j + 1];
                }
            }
        return g[0][0];
    }
}
