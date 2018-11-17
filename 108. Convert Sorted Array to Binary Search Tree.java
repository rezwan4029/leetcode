// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    TreeNode bstInsert(int nums[], int lo, int hi) {
        if(lo > hi) return null;
        int mid = (lo + hi) >> 1;
        TreeNode cur = new TreeNode(nums[mid]);
        cur.left = bstInsert(nums, lo, mid - 1);
        cur.right = bstInsert(nums, mid + 1, hi);
        return cur;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0 ) return null;
        return bstInsert(nums, 0, nums.length - 1);
    }
}
