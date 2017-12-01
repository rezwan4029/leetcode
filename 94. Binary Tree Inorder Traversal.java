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
}
