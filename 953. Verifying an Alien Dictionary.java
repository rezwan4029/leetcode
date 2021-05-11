// https://leetcode.com/problems/verifying-an-alien-dictionary


class Solution {
    
    boolean isSorted(char w1[], char w2[], int order[]) {
        
        int pos = 0;
        
        while(pos < w1.length && pos < w2.length) {
            if(order[w1[pos] - 'a'] != order[w2[pos] - 'a']) {
                return order[w1[pos] - 'a'] < order[w2[pos] - 'a'];
            }
            pos++;
        }
        
        return w1.length <= w2.length;
    }
    
    public boolean isAlienSorted(String[] words, String order) {
        int value[] = new int[26];
        int orderCount = 0;
        for(char x: order.toCharArray()) {
            value[x - 'a'] = ++orderCount;
        }
        
        for(int i = 0; i < words.length - 1; i++) {
            System.out.println(words[i].length() + words[i]+ " "+ words[i+1].length() + words[i+1]);
            if(!isSorted(words[i].toCharArray(), words[i + 1].toCharArray(), value)) {
                return false;
            }
        }
        return true;
    }
}
