// https://leetcode.com/problems/implement-trie-prefix-tree

class Node {
    
    char val;
    boolean word;
    HashMap<Character, Node> child = new HashMap<>();
    Node() {}
    Node(char _v) {
        val = _v;
        word = false;
    }
}

class Trie {
    
    Node root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        int n = word.length();
        Node move = root;
        for(int i = 0 ; i < n; i++) {
            char x = word.charAt(i);
            if(move.child.get(x) == null) {
                move.child.put(x, new Node(x));
            }
            move = move.child.get(x);
        }
        move.word = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int n = word.length();
        Node move = root;
        for(int i = 0 ; i < n; i++) {
            char x = word.charAt(i);
            if(move.child.get(x) == null) {
                return false;
            } else {
                move = move.child.get(x);
            }
        }
        return move.word;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int n = prefix.length();
        Node move = root;
        for(int i = 0 ; i < n; i++) {
            char x = prefix.charAt(i);
            if(move.child.get(x) == null) {
                return false;
            } else {
                move = move.child.get(x);
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
 
