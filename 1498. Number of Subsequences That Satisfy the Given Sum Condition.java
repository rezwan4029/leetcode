// https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/

class Solution {
    
    static int MD = (int)1e9 + 7;
    static int SZ = (int)1e5 + 2;
    int pow [] = new int[SZ];
    
    Solution() {
        for(int i = 0; i < SZ; i++) {
            pow[i] = (pow[i - 1] * 2) % MD;
        }
    }
    
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int x = 0, y = n - 1;
        int ans = 0;
        while(x <= y) {
            if(nums[x] + nums[y] <= target) {
                ans = (ans + pow[y - x]) % MD;
                x++;
            } else {
                y--;
            }
        }
        return ans;
    }
}
