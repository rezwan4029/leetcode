// https://leetcode.com/problems/add-and-search-word-data-structure-design/

class Node {
    char ch;
    HashMap<Character, Node> child = new HashMap<>();
    boolean wordEnding;
    
    Node() {}
    
    Node(char x) {
        ch = x;
        wordEnding = false;
    }
}

class WordDictionary {

    Node root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur = root;
        for(int i = 0 ; i < word.length(); i++) {
            if(cur.child.get(word.charAt(i)) == null) {
                cur.child.put(word.charAt(i), new Node(word.charAt(i)));
            }
            cur = cur.child.get(word.charAt(i));
        }
        cur.wordEnding = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word, 0, root);
    }
    
    public boolean match(String word, int pos, Node cur) {
        if(pos == word.length()) return cur.wordEnding;
        char ch = word.charAt(pos);
        if(ch != '.') {
            if(cur.child.get(ch) == null) return false;
            return match(word, pos + 1, cur.child.get(ch));
        } else {
            for(char i = 'a' ; i <= 'z'; i++) {
                 if(cur.child.get(i) != null) {
                     if(match(word, pos + 1, cur.child.get(i))) {
                         return true;
                     }
                 }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
