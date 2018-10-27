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
   
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length == 0) {
            return null;
        }
        
        if(lists.length == 1) {
            return lists[0];
        }
        
        int sz = lists.length / 2 + (lists.length % 2);
        
        boolean even = (lists.length % 2) == 0 ? true : false;
        
        int j = 0;
        
        ListNode[] newLists = new ListNode[sz];
        
        if(even) {
            for(int i = 0 ; i < lists.length ; i += 2) {
                newLists[j++] = mergeTwoLists(lists[i], lists[i+1]);
            }
        }else {
            for(int i = 0 ; i < lists.length - 1 ; i += 2) {
                newLists[j++] = mergeTwoLists(lists[i], lists[i+1]);
            }
            newLists[j] = lists[lists.length - 1];
        }
        
        return mergeKLists(newLists);
    }
    
}
