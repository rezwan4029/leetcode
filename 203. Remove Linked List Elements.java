// https://leetcode.com/problems/remove-linked-list-elements/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        if(head.val == val) return removeElements(head.next, val);
        ListNode now = head.next;
        ListNode last = head;
        while(now != null) {
            if(now.val == val) {
                last.next = now.next;
            } else {
                last = now;
            }
            now = now.next;
        }
        return head;
    }
    
}
