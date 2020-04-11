// https://leetcode.com/problems/reorganize-string/

class Solution {
    
    public String reorganizeString(String S) {
        int n = S.length();
        int freq[] = new int[26];
        for(char c: S.toCharArray()) {
            freq[c - 'a']++;
        }
        
        PriorityQueue<Item> q = new PriorityQueue<>(new Comparator<Item>(){
            public int compare(Item a, Item b) {
                if(a.count == b.count) {
                    return a.character.compareTo(b.character);
                }
                return b.count.compareTo(a.count);
            }
        });
        
        for(char c = 'a'; c <= 'z'; c++) {
            if(freq[c - 'a'] > (n + 1) / 2) {
                return "";
            }
            if(freq[c - 'a'] > 0) {
                q.add(new Item(c, freq[c - 'a']));
            }
        }
        
        StringBuilder ans = new StringBuilder();
        
        while(q.size() > 1) {
            Item a = q.poll();
            Item b = q.poll();
            
            ans.append(a.character);
            ans.append(b.character);
            
            if(a.count > 1) {
                q.add(new Item(a.character, a.count - 1));
            }
            
            if(b.count > 1) {
                q.add(new Item(b.character, b.count - 1));
            }
        }
        
        if(q.size() > 0) {
            ans.append(q.poll().character);
        }
        
        return ans.toString();
    }
    
    class Item {
        Character character;
        Integer count;
        Item(Character _character, Integer _count) {
            character = _character;
            count = _count;
        }
        
        public String toString() {
            return String.format("(c = %c, count = %d)", character, count);
        }
    }
}
