/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0); // dummy
        ListNode root = ans;
        while(l1 != null || l2!= null) {
            
            if(l1 != null && l2 != null) {
                if(l1.val <= l2.val) {
                    ans.next = l1;
                    l1 = l1.next;
                }else {
                    ans.next = l2;
                    l2 = l2.next;
                }
                ans = ans.next;
            }
            else if(l1 == null) {
                ans.next = l2;
                break;
            }else if(l2 == null) {
                ans.next = l1;
                break;
            }
        }
        return root.next;
    }
}
