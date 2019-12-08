class Solution {
    
    HashMap<String, Integer> dp;
    String nums[] = new String[26];
    
    Solution() {
        for(int i = 0; i < 26; i++) {
            nums[i] = String.valueOf(i + 1);
        }
    }
    
    public int solve(String s, String now) {
        if(now.equals(s)) {
            return 1;
        }
        if(dp.getOrDefault(now, -1) != -1) {
            return dp.get(now);
        }
        int ans = 0;
        for(int i = 0; i < 26; i++) {
            String v = now + nums[i];
            if(s.startsWith(v)) {
                ans += solve(s, v);
            }
        }
        dp.put(now, ans);
        return dp.get(now);
    }
    
    public int numDecodings(String s) {
        dp = new HashMap<>();
        return solve(s, "");
    }
}
