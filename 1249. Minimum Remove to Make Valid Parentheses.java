// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

class Solution {
    public String minRemoveToMakeValid(String s) {
        char ans [] = s.toCharArray();
        Stack<Integer> stk = new Stack<>();
        int len = s.length();
        for(int i = 0; i < len; i++) {
            if(ans[i] == '(') {
                stk.add(i);
            } else if(ans[i] == ')') {
                if(stk.isEmpty()) {
                    ans[i] = '$';
                } else {
                    stk.pop();
                }
            }
        }
        while(!stk.isEmpty()) {
            ans[stk.pop()] = '$';
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
            if(ans[i] == '$') continue;
            sb.append(ans[i]);
        }
        return sb.toString();
    }
}
