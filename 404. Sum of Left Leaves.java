// https://leetcode.com/problems/sum-of-left-leaves/

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
    
    int traverse(TreeNode root, boolean comingfromLeftBranch) {
        if(root.left == null && root.right == null) {
            if(comingfromLeftBranch) return root.val;
            return 0;
        }
        int r1 = 0;
        int r2 = 0;
        if(root.left != null) r1 = traverse(root.left, true);
        if(root.right != null) r2 = traverse(root.right, false);
        return r1 + r2;
    }
    
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return traverse(root, false);
    }
}
