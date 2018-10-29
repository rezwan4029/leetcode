// https://leetcode.com/problems/kth-smallest-element-in-a-bst

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
    
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;
        while(cur != null) {
            stk.add(cur);
            cur = cur.left;
        }
        TreeNode ans = null;
        while(!stk.isEmpty() && k > 0) {
            ans = stk.pop();
            if(ans.right != null) {
                cur = ans.right;
                while(cur != null) {
                    stk.add(cur);
                    cur = cur.left;
                }
            }
            k--;
        }
        return ans.val;
    }
    
}
