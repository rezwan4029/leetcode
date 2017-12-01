// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode root = head;
        while(head != null){
            size++;
            head = head.next;
        }
        if(n > size) {
            return root;
        }
        if(size == 1) {
            return null;
        }
        int removeItem = size - n + 1;
        if(removeItem == 1 ){
            return root.next;
        }
        head = root;
        ListNode previous = head;
        size = 1;
        head = head.next;
        while(head != null){
            size++;
            if(size == removeItem) {
                if(head.next == null){
                    previous.next = null;
                }else{
                    previous.next = head.next;   
                }
                break;
            }
            previous = head;
            head = head.next;
        }
        return root;
    }
}
