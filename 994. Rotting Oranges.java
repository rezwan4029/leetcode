// https://leetcode.com/problems/rotting-oranges/

class Solution {
    
    static int dx [] = new int [] {1, 0, -1, 0};
    static int dy [] = new int [] {0, 1, 0, -1};
    
    public int orangesRotting(int[][] grid) {
        int R = grid.length;
        if(R == 0) {
            return -1;
        }
        int C = grid[0].length;
        Queue<Position> q = new LinkedList<>();
        int freshCount = 0;
        for(int i = 0; i < R; i++)
            for(int j = 0; j < C; j++)
                if(grid[i][j] == 2)
                    q.add(new Position(i, j));
                else if(grid[i][j] == 1) 
                    freshCount++;
        if(q.size() == 0 && freshCount == 0) {
            return 0;
        }
        int ans = -1;
        while(!q.isEmpty()) {
            int sz = q.size();
            ans++;
            for(int i = 0; i < sz; i++) {
                Position u = q.poll();
                for(int k = 0; k < 4; k++) {
                    int nx = dx[k] + u.x;
                    int ny = dy[k] + u.y;
                    if(nx >= 0 && ny >= 0 && nx < R && ny < C && grid[nx][ny] == 1) {
                        q.add(new Position(nx, ny));
                        grid[nx][ny] = 2;
                    }
                }
            }
        }
        
        for(int i = 0; i < R; i++)
            for(int j = 0; j < C; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        
        return ans;
    }
    
    class Position {
        int x;
        int y;
        Position(int _x, int _y) {
            this.x = _x;
            this.y = _y;
        }
        Position(){}
    }
    
}
