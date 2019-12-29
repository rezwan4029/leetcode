// https://leetcode.com/problems/longest-palindromic-substring/

class Solution {
    
    int isPalindrome(String s, int dp[][], int i, int j) {
        if(i >= j) return 1;
        int ret = dp[i][j];
        if(ret != -1) return ret;
        ret = 0;
        if(s.charAt(i) == s.charAt(j)) {
            ret = isPalindrome(s, dp, i + 1, j - 1);
        }
        return dp[i][j] = ret;
    }
    
    public String longestPalindrome(String s) {
        int maxLen = 0;
        int x = 0, y = 0;
        int n = s.length();
        int dp[][] = new int[n][n];
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                dp[i][j] = -1;
        
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(isPalindrome(s, dp, i, j) == 1) {
                    if(maxLen < (j - i + 1)) {
                        maxLen = j - i + 1;
                        x = i;
                        y = j + 1;
                    }
                }
            }
        }
        
        return s.substring(x, y);
    }
}
