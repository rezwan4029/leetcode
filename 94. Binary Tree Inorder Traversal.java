// https://leetcode.com/problems/binary-tree-inorder-traversal/description/

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
    // Solution 1
    void traverse(TreeNode root, List<Integer> ret){
        if(root == null){
            return;
        }
        traverse(root.left, ret);
        ret.add(root.val);
        traverse(root.right, ret);
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> Ans = new ArrayList<Integer>();
        traverse(root, Ans);
        return Ans;
    }
    
    // Solution 2
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<Integer> ret = new ArrayList<>();
        List<Integer> r1 = inorderTraversal(root.left);
        List<Integer> r2 = inorderTraversal(root.right);
        ret.addAll(r1);
        ret.add(root.val);
        ret.addAll(r2);
        return ret;
    }
}
