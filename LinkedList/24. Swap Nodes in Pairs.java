/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode first = head;
        ListNode second = head.next;
        int tmp;
        while(first != null && second != null) {
            tmp = first.val;
            first.val = second.val;
            second.val = tmp;
            if(second.next != null) {
                first = second.next;
                second = second.next.next;//通过while来检查second是不是null
            } else {
                break;
            }
        }
        return head;
    }
}