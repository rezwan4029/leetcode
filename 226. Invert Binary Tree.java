// https://leetcode.com/problems/invert-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode u = q.poll();
                TreeNode left = u.left;
                TreeNode right = u.right;
                
                u.left = right;
                u.right = left;
                
                if(u.left != null) {
                   q.add(u.left);
                }
                if(u.right != null) {
                    q.add(u.right);
                }
            }
        }
        return root;
    }
    
}
