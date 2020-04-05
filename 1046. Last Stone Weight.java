// https://leetcode.com/problems/last-stone-weight/

class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> q = new PriorityQueue<>( new Comparator<>() {
            public int compare(Integer x, Integer y) {
                return y.compareTo(x);
            }
        });

        for(int i = 0; i < stones.length; i++) {
            q.add(stones[i]);
        }
        
        while(q.size() > 1) {
            int y = q.poll();
            int x = q.poll();
            if(x != y) {
                q.add(y - x);
            }
        }
        
        return q.size() > 0 ? q.peek(): 0;
    }
}
