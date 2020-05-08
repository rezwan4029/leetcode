// https://leetcode.com/problems/implement-magic-dictionary

class MagicDictionary {

    Node root;
    
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new Node();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String word: dict) {
            Node curr = root;
            for(char x: word.toCharArray()) {
                if(curr.next[ x - 'a'] == null) {
                    curr.next[ x - 'a'] = new Node();
                }
                curr = curr.next[ x - 'a'];
            }
            curr.ending = true;
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return findMatch(0, root, word, false);
    }
    
    boolean findMatch(int pos, Node cur, String word, boolean modified) {
        if(pos == word.length()) {
            return cur.ending && modified;
        }
        int x = (int)( word.charAt(pos) - 'a');
        boolean match = false;
        if(cur.next[x] != null) {
            match |= findMatch(pos + 1, cur.next[x], word, modified);
        }
        if(!match && !modified) {
            for(int i = 0; i < 26; i++) {
                if(i != x && cur.next[i] != null) {
                    match |= findMatch(pos + 1, cur.next[i], word, true);
                }
                if(match) break;
            }
        }
        return match;
    }
    
    class Node {
        Node next[] = new Node[26];
        boolean ending = false;
        Node(){}
    }
}
