// https://leetcode.com/problems/binary-tree-level-order-traversal/

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
    
    int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
    
    void traverse(TreeNode root, int currH, int h, List<List<Integer>> ans) {
        if(root == null) {
            return;
        }
        ans.get(currH).add(root.val);
        traverse(root.left, currH + 1, h, ans);
        traverse(root.right, currH + 1, h, ans);
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        int height = maxDepth(root);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < height; i++) {
            ans.add(new ArrayList<>());
        }
        traverse(root, 0, height, ans);
        return ans;
    }
}
