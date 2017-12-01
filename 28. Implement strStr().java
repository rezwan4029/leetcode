// https://leetcode.com/problems/implement-strstr/description/

class Solution {
    public int strStr(String haystack, String needle) {
        int needleLength = needle.length();
        int haystackLength = haystack.length();
        if(haystack.equals(needle)){
            return 0;
        }
        for(int i = 0 ; i < haystackLength; i++){
            if(needleLength + i <= haystackLength && haystack.substring(i, i + needleLength).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
