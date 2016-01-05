/*
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
*/
//[1,3,1,1]这种左端右端相同的情况比较麻烦
public class Solution {
    public boolean search(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (A[mid] == target)
                return true;
            if (A[start] < A[mid]) {//mid左边一直到start有序
                if (target >= A[start] && target < A[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else if (A[start] > A[mid]) {//mid右边一直到end有序
                if (target > A[mid] && target <= A[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            } else
                start++;
        }
        return false;
    }
}