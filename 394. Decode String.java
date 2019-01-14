// https://leetcode.com/problems/decode-string/

class Solution {
    
    public String decodeString(String s) {
        String exp = "";
        Stack<String> Stk = new Stack<>();
        Stack<Integer> Cnt = new Stack<>();
        int pos = 0;
        while(pos < s.length()) {
            if(s.charAt(pos) >= '0' && s.charAt(pos) <= '9') {
                String tmp = "";
                while(s.charAt(pos) >= '0' && s.charAt(pos) <= '9') {
                    tmp += s.charAt(pos);
                    pos++;
                }
                Cnt.add(Integer.valueOf(tmp));
            }
            if(s.charAt(pos) == '[') {
                Stk.add(exp);
                exp = "";
                pos++;
            } else if(s.charAt(pos) == ']') {
                int repeat = Cnt.pop();
                StringBuilder cur = new StringBuilder(Stk.pop());
                for(int i = 0 ; i < repeat; i++) {
                    cur.append(exp);
                }
                exp = cur.toString();
                pos++;
            } else {
                exp += s.charAt(pos++);
            }
        }
        return exp;
    }
}
