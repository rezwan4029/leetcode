// https://leetcode.com/problems/word-ladder/

class Node {
    
    String str = "";
    int cost = 0;
    
    Node(String _s, int _c){
        str = _s;
        cost = _c;
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
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Queue<Node> q = new LinkedList<>();
        for(String s : wordList) {
            if(isPossible(s, beginWord)) q.add(new Node(s, 1));
        }
        if(q.isEmpty()) return 0;
        Map<String, List<String>> graph = buildGraph(wordList);
        HashSet<String> used = new HashSet<>();
        while(!q.isEmpty()) {
            Node u = q.remove();
            if(u.str.equals(endWord)) {
                return u.cost + 1;
            }
            used.add(u.str);
            for(String s : graph.get(u.str)) {
                if(!used.contains(s)) q.add(new Node(s, u.cost + 1));
            }
        }
        return 0;
    }
    
}
