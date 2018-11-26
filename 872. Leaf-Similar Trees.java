// https://leetcode.com/problems/leaf-similar-trees/

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
    
    void dfs(TreeNode root, LinkedList<Integer> leafs) {
        if(root != null) {
            if(root.left == null && root.right == null) {
                leafs.add(root.val);
            }
            dfs(root.left, leafs);
            dfs(root.right, leafs);
        }
    }
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        LinkedList<Integer> t1 = new LinkedList<>();
        LinkedList<Integer> t2 = new LinkedList<>();
        dfs(root1, t1);
        dfs(root2, t2);
        return t1.equals(t2);
    }
    
}
