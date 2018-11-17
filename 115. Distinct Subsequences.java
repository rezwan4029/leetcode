class Solution {

    String S;
    String T;
    int SLen;
    int TLen;
    
    int solve(int i, int j, int [][] dp) {
        if(j == TLen) return 1;
        if(i == SLen) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ret = 0;
        if(S.charAt(i) == T.charAt(j)) { 
            ret += solve(i + 1, j + 1, dp);
        }
        ret += solve(i + 1, j, dp);
        return dp[i][j] = ret;
    }
    
    public int numDistinct(String s, String t) {
        S = s;
        T = t;
        SLen = S.length();
        TLen = T.length();
        
        if(TLen > SLen) return 0;
        
        int [][]dp = new int[SLen][TLen];
        
        for(int i = 0  ; i < SLen; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return solve(0, 0, dp);
    }
    
}
