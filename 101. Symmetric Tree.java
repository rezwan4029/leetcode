// https://leetcode.com/problems/symmetric-tree/

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
    
    public boolean isMirror(TreeNode x, TreeNode y) {
        if(x == null && y == null) {
            return true;
        }
        if(x == null) return false;
        if(y == null) return false;
        if(x.val != y.val) return false;
        return isMirror(x.left, y.right) && isMirror(x.right, y.left);
    }
    
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }
}
