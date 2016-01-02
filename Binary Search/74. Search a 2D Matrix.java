/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //两次binary search，先搜索每行的第一个元素，找到目标行，再对那个行binary search
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m - 1;
        int mid = left + (right - left) / 2;
        int row = -1;
        while(left <= right) {
            if(matrix[mid][0] <= target && matrix[mid][n - 1] >= target) {
                row = mid;
                break;
            } else if(matrix[mid][0] > target) {
                right = mid - 1;
            } else if(matrix[mid][n - 1] < target) {
                left = mid + 1;
            }
            mid = left + (right - left) / 2;
        }
        if(left > right) {
            return false;
        }
        left = 0;
        right = n - 1;
        mid = left + (right - left) / 2;
        while(left <= right) {
            if(matrix[row][mid] == target) {
                return true;
            } else if(matrix[row][mid] > target) {
                right = mid - 1;
            } else if(matrix[row][mid] < target) {
                left = mid + 1;
            }
            mid = left + (right - left) / 2;
        }
        return false;
    }
}