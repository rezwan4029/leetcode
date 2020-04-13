// https://leetcode.com/problems/word-break/

class Solution {
    
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
            if(seen.getOrDefault(now, false)) continue;
            seen.put(now, true);
            if(now.equals(s)) return true;
            for(int i = 0 ; i < n; i++) {
                String tobe = now + wordDict.get(i);
                if(s.startsWith(tobe)){
                    q.add(tobe);
                }
            }
        }
        return false;
    }
}
