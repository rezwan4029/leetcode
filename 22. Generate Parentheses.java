// https://leetcode.com/problems/generate-parentheses/

class Solution {
    
    List<String> ans = new ArrayList<>();
    
    void parenthesis(int open, int close, String cur, int n) {
        if(n * 2 == cur.length()) {
            ans.add(cur);
            return;
        }
        if(open < n) {
            parenthesis(open + 1, close, cur + "(", n);
        }
        if(close < open) {
            parenthesis(open, close + 1, cur + ")", n);
        }
    }
        
    public List<String> generateParenthesis(int n) {
        parenthesis(0, 0, "", n);
        return ans;
    }
   
}
