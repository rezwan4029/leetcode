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
    
    // Solution 1
    
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
    
    // Solution 2
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(root.val);
        ans.add(curr);
        q.add(root);
        while(!q.isEmpty()){
            curr = new ArrayList<>();
            int qSize = q.size();
            for(int i = 0 ; i < qSize; i++) {
                TreeNode u = q.remove();
                if(u.left != null) {
                    q.add(u.left);
                    curr.add(u.left.val);
                }
                if(u.right != null) {
                    q.add(u.right);
                    curr.add(u.right.val);
                }
            }
            if(!curr.isEmpty()) ans.add(curr);
        }
        return ans;
    }
    
}
