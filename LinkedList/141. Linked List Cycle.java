/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //two pointers
    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode first = head;
        ListNode second = head;
        while(first != null && second != null) {
            first = first.next;
            if(second.next != null) {
                second = second.next.next;
            } else {
                break;
            }
            if(first == second) {
                return true;
            }
        }
        return false;
    }
}