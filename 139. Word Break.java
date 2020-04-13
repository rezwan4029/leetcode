// https://leetcode.com/problems/word-break/

class Solution1 {
    
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = wordDict.size();
        Queue<String>q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++) {
            if(s.startsWith(wordDict.get(i))){
                q.add(wordDict.get(i));
            }
        }
        if(q.isEmpty()) return false;
        HashMap<String, Boolean> seen = new HashMap<>();
        while(!q.isEmpty()) {
            String now = q.poll();
            if(seen.getOrDefault(now, false)) {
                continue;
            }
            seen.put(now, true);
            if(now.equals(s)) return true;
            for(int i = 0 ; i < n; i++) {
                String next = now + wordDict.get(i);
                if(s.startsWith(next)){
                    q.add(next);
                }
            }
        }
        return false;
    }
}

// DP solution
class Solution2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Set<String> dict = new HashSet<>();
        for (String word : wordDict) {
            dict.add(word);
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            if (dict.contains(s.substring(0, i))) {
                dp[i] = true;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
