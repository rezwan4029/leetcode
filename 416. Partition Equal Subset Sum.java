// https://leetcode.com/problems/partition-equal-subset-sum/

class Solution1 {

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int s: nums) {
            totalSum += s;
        }
        if(totalSum % 2 != 0) {
            return false;
        }
        int dp[][] = new int[nums.length][totalSum + 1];
        for(int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, nums, totalSum, dp);
    }
    
    boolean solve(int pos, int curSum, int nums[], int totalSum, int dp[][]) {
        if(pos == nums.length || curSum * 2 > totalSum) {
            return false;
        }
        if(curSum * 2 == totalSum) {
            return true;
        }
        if(dp[pos][curSum] != -1) {
            return dp[pos][curSum] == 1;
        }
        boolean ret = solve(pos + 1, curSum, nums, totalSum, dp) | solve(pos + 1, curSum + nums[pos], nums, totalSum, dp);
        dp[pos][curSum] = ret ? 1 : 0;
        return ret;
    }
}

class Solution2 {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        int n = nums.length;
        for(int s: nums) {
            totalSum += s;
        }
        if(totalSum % 2 != 0) {
            return false;
        }
        int half = totalSum / 2;
        
        boolean dp[][] = new boolean[n + 1][half + 1];
        for(int i = 1; i <= n; i++) {
            dp[i][0] = true;
        }

        for(int i = 1; i <= n; i++) {
            for(int s = 1; s <= half; s++) {
                if(s >= nums[i - 1]) {
                    dp[i][s] = dp[i - 1][s] | dp[i - 1][ s - nums[i - 1] ];
                } else {
                    dp[i][s] = dp[i - 1][s];
                }
            }
        }
        return dp[n][half];
    }
    
}
