/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans = head;
        ListNode tmp1 = head;
        ListNode tmp2 = head;
        boolean flag = true;
        while(flag) {
            boolean flag2 = true;
            for(int i = 0; i < n; i++) {
                if(tmp2.next != null) {
                    tmp2 = tmp2.next;
                } else {
                    flag2 = false;
                    break;
                }
            }
            if(tmp2.next == null) {
                if(flag2 == false) {//注意处理head的问题
                    ans = ans.next;
                    flag = false;
                } else {
                    tmp1.next = tmp1.next.next;
                    flag = false;
                }
            } else {
                tmp2 = tmp1.next;//要先写tmp2 = tmp1.next;不能先写tmp1 = tmp1.next;，否则tmp1指向的对象已经改变了
                tmp1 = tmp1.next;
            }
        }
        return ans;
    }
}