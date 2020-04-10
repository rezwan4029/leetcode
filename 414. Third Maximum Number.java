// https://leetcode.com/problems/third-maximum-number/

class Solution {
    
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++) {
            if(!q.contains(nums[i])) {
                if(q.size() < 3) {
                    q.add(nums[i]);
                } else if(q.peek() < nums[i]) {
                    q.poll();
                    q.add(nums[i]);
                }
            }
        }
        if(q.size() == 3) {
            return q.peek();
        }
        while(q.size() > 1) {
            q.poll();
        }
        return q.peek();
    }
}
