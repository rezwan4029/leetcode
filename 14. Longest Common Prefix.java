// https://leetcode.com/problems/longest-common-prefix/description/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        int allStrs = strs.length;
        
        if(allStrs == 0){
            return "";
        }
        
        int len = strs[0].length();
        
        if(allStrs == 1){
            return strs[0];
        }
        
        for(int i = 0 ; i < allStrs ; i++){
            len = Math.min(len, strs[i].length());
        }
        int ans = 0;
        for(int i = 0 ; i < len ; i++) {
            boolean flag = true;
            for(int j = 1 ; j < allStrs; j++) {
                if(strs[0].charAt(i) != strs[j].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                ans++;
            }else{
                break;
            }
        }
        return strs[0].substring(0, ans);
    }
}
