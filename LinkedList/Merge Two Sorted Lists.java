/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 */

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode temp = l;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                l.next = l1;
                l = l.next;
                l1 = l1.next;
            } else if(l1.val > l2.val) {
                l.next = l2;
                l = l.next;
                l2 = l2.next;
            }
        }
        if (l1 == null && l2 == null) {
            return temp.next;
        } else if (l1 != null && l2 == null) {
            while (l1 != null) {
                l.next = l1;
                l = l.next;
                l1 = l1.next;
            }
            return temp.next;
        } else if (l2 != null && l1 == null) {
            while (l2 != null) {
                l.next = l2;
                l = l.next;
                l2 = l2.next;
            }
            return temp.next;
        }
        return temp.next;
    }
}