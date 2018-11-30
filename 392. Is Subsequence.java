// https://leetcode.com/problems/is-subsequence/

class Solution {
    
    int lowerBound(List<Integer> arr, int key) {
        int l = 0, h = arr.size();
        while(l < h) {
            int m = (l + h) >> 1;
            if( key <= arr.get(m)) {
                h = m;
            } else {
                l = m + 1;
            } 
        }
        return l;
    }
    
    boolean solve(Map<Character, List<Integer>> dict, String s, int pos, int last) {
        if(pos == s.length()) {
            return true;
        }
        
        List<Integer> now = dict.get(s.charAt(pos));
        for(int cur = lowerBound(now, last + 1); cur < now.size(); cur++ ) {
            if(last < now.get(cur)) {
                if(solve(dict, s, pos + 1, now.get(cur))) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> dict = new HashMap<>();
        
        for(int i = 0 ; i < s.length(); i++) {
            dict.put(s.charAt(i), new ArrayList<>());
        }
        
        for(int i = 0; i < t.length(); i++) {
            List<Integer> cur = dict.get(t.charAt(i));
            if(cur == null) continue;
            cur.add(i);
            dict.put(t.charAt(i), cur);
        }
        for(int i = 0 ; i < s.length(); i++) {
            if(dict.get(s.charAt(i)) == null) {
                return false;
            }
        }
        return solve(dict, s, 0, -1);
    }
}
