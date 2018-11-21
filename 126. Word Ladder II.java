// https://leetcode.com/problems/word-ladder-ii

class Node {
    
    String str = "";
    int cost = 0;
    List<String> path = new ArrayList<>();
    
    Node(String _s, int _c, String start){
        str = _s;
        cost = _c;
        path.add(start);
        path.add(str);
    }
    
    Node(String _s, int _c, List<String> _p){
        str = _s;
        cost = _c;
        path = new ArrayList<>(_p);
    }
    
    void addToPath(String x) {
        path.add(x);
    }
}

class Solution {
    
     boolean isPossible(String a, String b) {
        int mismatch = 0;
        for(int i = 0 ; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) mismatch++;
            if(mismatch > 1) return false;
        }
        return mismatch == 1 ? true: false;
    }
    
    Map<String, List<String>> buildGraph(List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();
        for(int i = 0 ; i < wordList.size(); i++) {
            List<String> ways = new ArrayList<>();
            for(int j = 0; j < wordList.size(); j++) {
                if(isPossible(wordList.get(i), wordList.get(j))) {
                    ways.add(wordList.get(j));
                }
            }
            graph.put(wordList.get(i), ways);
        }
        return graph;
    }
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List< List<String> > ans = new ArrayList<>();
        if(!wordList.contains(endWord)) return ans;
        Queue<Node> q = new LinkedList<>();
        for(String s : wordList) {
            if(isPossible(s, beginWord)) {
                Node n = new Node(s, 1, beginWord);
                q.add(n);
            }
        }
        if(q.isEmpty()) return ans;
        Map<String, List<String>> graph = buildGraph(wordList);
        HashSet<String> used = new HashSet<>();
        int minCost = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            Node u = q.remove();
            if(u.str.equals(endWord)) {
                ans.add(u.path);
                minCost = Math.min(minCost, u.cost + 1);
            }
            used.add(u.str);
            for(String s : graph.get(u.str)) {
                if(!used.contains(s)) {
                    Node v = new Node(s, u.cost + 1, u.path);
                    v.addToPath(s);
                    q.add(v);
                }
            }
        }
        List<List<String>> finalAns = new ArrayList<>();
        for(List<String> r : ans) {
            if(r.size() == minCost) finalAns.add(r);
        }
        return finalAns;
    }
}
