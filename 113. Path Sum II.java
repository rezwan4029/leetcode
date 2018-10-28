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
class Solution {
    
    List<List<Integer>> ans ;
    
    public void hasPathSum(TreeNode root, int sum, LinkedList<Integer> curr) {
        if(root == null) {
            return ;
        }
        
        if(root.left == null && root.right == null && sum == root.val) {
            curr.add(root.val);
            ans.add(curr);
            curr.removeLast();
            return;
        }
        
        curr.add(root.val);
        hasPathSum(root.left, sum - root.val, curr);
        curr.removeLast();
        
        curr.add(root.val);
        hasPathSum(root.right, sum - root.val, curr);
        curr.removeLast();
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans = new ArrayList<>();
        hasPathSum(root, sum, new LinkedList<>());
        return ans;
    }
    
}
