// https://leetcode.com/problems/replace-words/

class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Node root = new Node();
        for(String word: dict) {
            insert(root, word);
        }
        String words[] = sentence.split(" ");
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < words.length; i++) {
            if(i != 0) {
                output.append(" ");
            }
            output.append(findSuccessor(root, words[i]));
        }
        return output.toString();
    }
    
    String findSuccessor(Node root, String word) {
        Node cur = root;
        for(int i = 0; i < word.length(); i++) {
            int x = word.charAt(i) - 'a';
            if(cur.child[x] == null) {
                break;
            }
            if(cur.child[x].ended) {
                return cur.child[x].word;
            }
            cur = cur.child[x];
        }
        return word;
    }
    
    void insert(Node root, String word) {
        Node cur = root;
        for(char x: word.toCharArray()) {
            int v = x - 'a';
            if(cur.child[v] == null) {
                cur.child[v] = new Node();
            }
            cur = cur.child[v];
        }
        cur.ended = true;
        cur.word = word;
    }
    
    class Node {
        Node child[] = new Node[26];
        boolean ended = false;
        String word;
        Node(){}
    }
}
