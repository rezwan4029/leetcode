// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted

class Solution {
    
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int i = 0, j = n - 1;
        int p = -1, q = -1;
        while( i < j) {
            int x = numbers[i] + numbers[j];
            if(target > x ) i++;
            else if(target < x) j--;
            else {
                p = i + 1;
                q = j + 1;
                break;
            }
        }
        return new int[] {p, q};
    }
    
}
