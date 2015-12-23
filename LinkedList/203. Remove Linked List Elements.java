/*
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.
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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        ListNode ans = head;
        ListNode sol = head;
        while(sol.val == val) {
            sol = sol.next;
            ans = sol;//注意更新头结点
            if(sol == null) {//所有的都删了，要返回null
                return null;
            }
        }
        while(sol.next != null) {
            if(sol.next.val == val) {
                sol.next = sol.next.next;
            } else {
                sol = sol.next;
            }
        }
        return ans;
    }
}