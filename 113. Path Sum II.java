// https://leetcode.com/problems/path-sum-ii

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
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
    
    List<List<Integer>> ans;
    
    void solve(TreeNode root, int sum, List<Integer> path) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            if(sum == root.val) {
                path.add(root.val);
                ans.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(root.val);
        solve(root.left, sum - root.val, path);
        solve(root.right, sum - root.val, path);
        path.remove(path.size()-1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans = new ArrayList<>();
        solve(root, sum, new ArrayList<>());
        return ans;
    }
}
