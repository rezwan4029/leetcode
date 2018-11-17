// https://leetcode.com/problems/remove-duplicates-from-sorted-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = head;
        ListNode last = root;
        if(head == null || head.next == null) return head;
        ListNode now = head.next;
        while(now != null) {
            if(last.val == now.val) {
                last.next = now.next;
                now = now.next;
                continue;
            }
            last = now;
            now = now.next;
        }
        return root;
    }
    
}
