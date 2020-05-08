// https://leetcode.com/problems/add-and-search-word-data-structure-design


class WordDictionary {

    Trie root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie curr = root;
        for(char x: word.toCharArray()) {
            if(curr.next[ x - 'a'] == null) {
                curr.next[ x - 'a' ] = new Trie();
            }
            curr = curr.next[ x - 'a' ];
        }
        curr.ending = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return findMatch(root, 0, word);
    }
    
    private boolean findMatch(Trie cur, int pos, String word) {
        if(pos == word.length()) {
            return cur.ending;
        }
        char x = word.charAt(pos);
        if(x != '.') {
            if(cur.next[x - 'a'] == null) {
                return false;
            }
            return findMatch(cur.next[x - 'a'], pos + 1, word);
        }
        
        boolean ans = false;
        for(int i = 0; i < 26; i++) {
            if(cur.next[i] != null) {
                ans |= findMatch(cur.next[i], pos + 1, word);
            }
            if(ans) break;
        }
        return ans;
    }
    
    class Trie {
        Trie next[] = new Trie[26];
        boolean ending = false;
        Trie(){}
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
