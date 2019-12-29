// https://leetcode.com/problems/backspace-string-compare/

class Solution {
    
    public Stack<Character> getBackspace(String S) {
        Stack<Character> Stk = new Stack<>();
        for(int i = 0 ; i < S.length(); i++) {
            char x = S.charAt(i);
            if(x == '#') {
                if(Stk.size() > 0) {
                    Stk.pop();
                }
            } else {
                Stk.push(x);
            }
        }
        return Stk;
    }
    
    public boolean backspaceCompare(String S, String T) {
        
        Stack<Character> S1 = getBackspace(S);
        Stack<Character> T1 = getBackspace(T);
        
        if(T1.size() != S1.size()) return false;
        
        while(!S1.isEmpty() && !T1.isEmpty()) {
            if(S1.pop() != T1.pop()) {
                return false;
            }    
        }
        return true;
    }
}
