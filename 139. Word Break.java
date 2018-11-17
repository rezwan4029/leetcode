// https://leetcode.com/problems/word-break/

class Solution {
    
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = wordDict.size();
        Queue<String>q = new LinkedList<>();
        Collections.sort(wordDict);
        Collections.reverse(wordDict);
        HashMap<String, Boolean> seen = new HashMap<>();
        for(int i = 0 ; i < n ; i++) {
            if(s.startsWith(wordDict.get(i))){
                q.add(wordDict.get(i));
            }
        }
        if(q.isEmpty()) return false;
        while(!q.isEmpty()) {
            String now = q.remove();
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
