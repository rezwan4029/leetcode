// https://leetcode.com/problems/minimum-path-sum/


class Solution {
    
    static int MX = (int)1e6;
    
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for(int i = n - 1; i >= 0; i--)
            for(int j = m - 1; j >= 0; j--) {
                if(i + 1 < n && j + 1 < m) {
                    grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
                } else if(i + 1 < n) {
                     grid[i][j] +=  grid[i + 1][j];
                } else if(j + 1 < m) {
                     grid[i][j] +=  grid[i][j + 1];
                } 
            }
        return grid[0][0];
    }
}
