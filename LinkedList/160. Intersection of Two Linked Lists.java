/*
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        int len1 = 0;
        int len2 = 0;
        int tmp = 0;
        ListNode ha = headA;
        ListNode hb = headB;
        while(ha.next != null) {
            len1++;
            ha = ha.next;
        }
        while(hb.next != null) {
            len2++;
            hb = hb.next;
        }
		//总的长度进行比较，去除多余的长度
        // tmp = (len1 > len2) ? (len1 - len2) : (len2 - len1);
        if(len1 > len2) {
            tmp = len1 - len2;
            ha = headA;
            hb = headB;
            for(int i = 0; i < tmp; i++) {
                ha = ha.next;
            }
        } else {
            tmp = len2 - len1;
            ha = headA;
            hb = headB;
            for(int i = 0; i < tmp; i++) {
                hb = hb.next;
            }
        }
        while(ha != hb) {
            ha = ha.next;
            hb = hb.next;
        }
        return ha;
    }
}