/*
Reverse a singly linked list.
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
    public ListNode reverseList(ListNode head) {
        // if (head == null || head.next == null) return head;
        // reverseList(head.next).next = head;
        // return head;
        if (head == null || head.next == null) return head;
        ListNode temp = reverseList(head.next);//temp就是reverse之后的linked list的新head
        head.next.next = head;
        head.next = null;
        return temp;
    }
}