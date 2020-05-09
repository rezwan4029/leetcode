// https://leetcode.com/problems/longest-word-in-dictionary/

class Solution {
    
    public String longestWord(String[] words) {
        Node root = new Node();
        root.ended = true;
        for(int i = 0; i < words.length; i++) {
            build(root, words[i]);
        }

        String ans = "";
        int maxLength = 0;
        for(int i = words.length - 1; i >= 0; i--) {
            if(maxLength <= words[i].length()) {
                if(search(root, words[i])) {
                    if(maxLength < words[i].length()) {
                        maxLength = words[i].length();
                        ans = words[i];
                    } else if(maxLength == words[i].length()) {
                        if(ans.compareTo(words[i]) > 0) {
                            ans = words[i];
                        }
                    }
                }
            }
        }
        return ans;
    }
    
    void build(Node root, String word) {
        Node cur = root;
        for(char x: word.toCharArray()) {
            if(cur.child[x - 'a'] == null) {
                cur.child[x - 'a'] =  new Node();
            }
            cur = cur.child[x - 'a'];
        }
        cur.ended = true;
    }
    
    boolean search(Node root, String word) {
        Node cur = root;
        for(char x: word.toCharArray()) {
            if(!cur.child[x - 'a'].ended) {
                return false;
            }
            cur = cur.child[x - 'a'];
        }
        return cur.ended;
    }
    
    class Node {
        Node child[] = new Node[26];
        boolean ended = false;
        Node(){}
    }
}
