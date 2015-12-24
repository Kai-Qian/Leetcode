/*
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
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
    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }
        //快慢指针法，slow走了一半，fast走完整个list
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //结束while的时候，slow在中点处（list为奇数个）或者刚过中点处（list为偶数个）
        if(fast != null) {
            slow = reverseList(slow.next);
        } else {
            slow = reverseList(slow);
        }
        while(slow != null) {
            if(slow.val != head.val) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
    public ListNode reverseList(ListNode head) {
        // if (head == null || head.next == null) return head;
        // reverseList(head.next).next = head;
        // return head;
        if (head == null || head.next == null) return head;
        ListNode temp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
    //用stack，代码对，但超时了，可能只压一般的list到stack里会好
    // public boolean isPalindrome(ListNode head) {
    //     if(head == null) {
    //         return true;
    //     }
    //     ListNode front = head;
    //     ListNode back = head;
    //     Stack<ListNode> s = new Stack<ListNode>();
    //     s.push(back);
    //     int len = 1;
    //     while(back.next != null) {
    //         len++;
    //         back = back.next;
    //         s.push(back);
    //     }
    //     int count = 0;
    //     while(front.val == s.pop().val && (count < len / 2)) {
    //         count++;
    //         front = front.next;
    //     }
    //     return count == len / 2 ? true : false;
    // }
}