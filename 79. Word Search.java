// https://leetcode.com/problems/word-search/

class Solution {
    
    int []dx = new int[] {1, 0, -1, 0};
    int []dy = new int[] {0, 1, 0, -1};
    
    
    boolean dfs(int x, int y, int pos, int R, int C, boolean[][] vis, char[][] board, String word) {
        if(pos == word.length()) {
            return true;
        }
        vis[x][y] = true;
        for(int i = 0 ; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            
            if(nx >= 0 && ny >= 0 && nx < R && ny < C && board[nx][ny] == word.charAt(pos) && !vis[nx][ny]) {
                if(dfs(nx, ny, pos + 1, R, C, vis, board, word)) return true;
            }
           
        }
        vis[x][y] = false;
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        if(word == null || word == "" || board.length == 0) return false;
        int R = board.length;
        int C = board[0].length;
        boolean vis[][] = new boolean[R][C];
        for(int i = 0 ; i < R; i++) {
            for(int j = 0 ; j < C; j++) {
                if(word.charAt(0) == board[i][j]) { 
                    if(dfs(i, j, 1, R, C, vis, board, word)) return true;
                }
            }
        }
        return false;

    }
}
