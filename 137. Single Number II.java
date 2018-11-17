// https://leetcode.com/problems/single-number-ii/

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0 ; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        int ans = 0;
        while(it.hasNext()) {
            Map.Entry<Integer, Integer> cur = it.next();
            if(cur.getValue() == 1) {
                ans = cur.getKey();
                break;
            }
        }
        return ans;
    }
}
