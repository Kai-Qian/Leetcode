/*
Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

Hint:

Expected runtime complexity is in O(log n) and the input is sorted.
*/
/*
思路类似于H-index I中从右往左scan找到sum[-i:] >= i就return.

len - mid就是有多少paper的citations >= citations[mid]
*/
public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int left = 0;
        int right = len - 1;
        int mid = left + (right - left) / 2;
        while(left <= right) {
            if(len - mid == citations[mid]) {
                return len - mid;
            } else if(len - mid > citations[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = left + (right - left) / 2;
        }
        return len - left;
    }
}