// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
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
    
    TreeNode bst(int lo, int hi, int a[]) {
        if(lo > hi) return null;
        int mid = (lo + hi) >> 1;
        TreeNode cur = new TreeNode(a[mid]);
        cur.left = bst(lo, mid - 1, a);
        cur.right = bst(mid + 1, hi, a);
        return cur;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        ListNode tp = head;
        int sz = 0;
        while(tp != null) {
            tp = tp.next;
            sz++;
        }
        int [] a = new int[sz];
        tp = head;
        sz = 0;
        while(tp != null) {
            a[sz++] = tp.val;
            tp = tp.next;
        }
        return bst(0, sz - 1, a);
    }
    
}
