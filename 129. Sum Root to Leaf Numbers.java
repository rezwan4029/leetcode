// https://leetcode.com/problems/sum-root-to-leaf-numbers/ 

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
    
    int sum(TreeNode root, int s) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null ) {
            return 10 * s + root.val;
        }
        return sum(root.left, 10 * s + root.val) + sum(root.right, 10 * s + root.val);
    }
    
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }
}
