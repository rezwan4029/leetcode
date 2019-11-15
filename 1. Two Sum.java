class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> data = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            List<Integer> val = data.getOrDefault(nums[i], new ArrayList<>());
            val.add(i);
            data.put(nums[i], val);
        }
        int ans[] = new int[2];
        boolean f = false;
        for(int i = 0 ; i < nums.length && !f; i++) {
            int need = target - nums[i];
            if(data.get(need) != null) {
                List<Integer> val = data.get(need);
                for(Integer x: val) {
                    if(x != i) {
                        ans[0] = i;
                        ans[1] = x;
                        f = true;
                        break;
                    }
                }
            }
        }

        return ans;
    }
}
