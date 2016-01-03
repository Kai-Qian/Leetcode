/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/
public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //对有0的行与列进行标记
        int[] column = new int[n];
        int[] row = new int[m];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    column[j] = 1;
                    row[i] = 1;
                }
            }
        }
        //先找列再找行，找行的同时进行对行的标零，同时对已经标0的行进行标记，以免下次再标0
        for(int j = 0; j < n; j++) {
            if(column[j] != 1) {
                continue;
            }
            for(int i = 0; i < m; i++) {
                if(row[i] == 1) {
                    for(int k = 0; k < n; k++) {
                        matrix[i][k] = 0;
                    }
                    row[i] = 0;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}