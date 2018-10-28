// https://leetcode.com/problems/balanced-binary-tree/

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
    
    boolean balanced = true;
    
    int height(TreeNode x) {
        if(x == null) {
            return 0;
        }
        int p = height(x.left);
        int q = height(x.right);
        
        balanced &=  Math.abs(p - q) > 1 ? false : true;
        
        return Math.max(p, q) + 1;
    }
    
    public boolean isBalanced(TreeNode root) {
        balanced = true;
        if(root == null) return true;
        height(root);
        return balanced;
    }
    
}
