// https://leetcode.com/problems/product-of-array-except-self/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int l[] = new int[n + 2];
        int r[] = new int[n + 2];
        Arrays.fill(l, 1);
        Arrays.fill(r, 1);
        for(int i = 0; i < n; i++) {
            l[i + 1] = l[i] * nums[i];
        }
        for(int i = n - 1; i >= 0; i--) {
            r[i + 1] = r[i + 2] * nums[i];
        }
        for(int i = 1; i <= n; i++) {
            nums[i - 1] = l[i - 1] * r[ i + 1];
        }
        return nums;
    }
}
