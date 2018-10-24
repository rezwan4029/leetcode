class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        int ans = 0, i = 0, j = 0;
        HashSet<Character> map = new HashSet<>();
        int n = s.length();
        while(i < n && j < n) {
            if(!map.contains(s.charAt(j))) {
                map.add(s.charAt(j));
                j += 1;
                ans = Math.max(ans, j - i);
            }else {
                map.remove(s.charAt(i));
                i += 1;
            }
        }
        return ans;
    }
}
