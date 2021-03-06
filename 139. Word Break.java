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

// Keep track of successful postion which was able to reach
class Solution2 {
    
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = wordDict.size();
        Queue<Integer>q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++) {
            if(s.startsWith(wordDict.get(i))){
                q.add(wordDict.get(i).length());
            }
        }
        if(q.isEmpty()) return false;
        int len = s.length();
        boolean seen [] = new boolean[len + 1];
        while(!q.isEmpty()) {
            int now = q.poll();
            if(seen[now]) continue;
            seen[now] = true;
            if(now == len) return true;
            for(int i = 0; i < n; i++) {
                String next = s.substring(now, len);
                if(next.startsWith(wordDict.get(i))){
                    q.add(now + wordDict.get(i).length());
                }
            }
        }
        return false;
    }
}


// DP solution

class Solution3 {
    
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean dp[] = new boolean[n+1];
        dp[0] = true;
        
        for(int left = 0; left< s.length(); left++){
            if(!dp[left]) continue;
            for(String wordStr : wordDict){
                int right = left + wordStr.length();
                if(right<=n && s.substring(left,right).equals(wordStr))
                    dp[right] = true;
            }    
        }
        return dp[n];
    }
    
}
