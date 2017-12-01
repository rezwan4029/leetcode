// https://leetcode.com/problems/valid-parentheses/description/

class Solution {
    
    public boolean isParamMatches(char x, char y) {
        if(x == '(' && y == ')') return true;
        if(x == '{' && y == '}') return true;
        if(x == '[' && y == ']') return true;
        return false;
    }
    
    public boolean isClosing(char x){
        return (x == ')' || x == '}' || x == ']');
    }
    
    public boolean isValid(String s) {
        Stack<Character>Stk = new Stack<Character>();
        int len = s.length();
        if(len == 0) return true;
        if(len == 1) return false;
        Stk.push(s.charAt(0));
        for(int i = 1 ; i < len ; i++) {
            if(isClosing(s.charAt(i))) {
                if(!Stk.empty() && isParamMatches(Stk.peek(), s.charAt(i))) {
                    Stk.pop();
                }else {
                    return false;
                }
            }else{
                Stk.push(s.charAt(i));
            }
        }
        if(!Stk.isEmpty()) {
            return false;
        }
        return true;
    }
}
