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
class Solution1 {
    
    void traverse(TreeNode root, List<Integer> ret){
        if(root == null) {
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

class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        if(root == null) {
            return order;
        }
        Stack<TreeNode> Stk = new Stack<>();
        Stk.add(root);
        while(Stk.size() != 0) {
            if(root != null && root.left != null) {
                Stk.add(root.left);
                root = root.left;
            } else {
                TreeNode curr = Stk.pop();
                order.add(curr.val);
                if(curr.right != null) {
                    Stk.add(curr.right);
                    root = curr.right;
                }
            }
        }
        return order;
    }
    
}
