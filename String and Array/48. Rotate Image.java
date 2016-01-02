/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/
/*
但是在这里，题目中也要求了，就在原数组中，应该怎么旋转？
 
接着上面的分析，以n=3为例：
 
image旋转后变为image
 
我们把焦点放在一个元素的旋转上，可以看出要在员数组中旋转，在不丢失数据的情况下，每个值的要旋转会“波及”4个数，以1为例波及到了1,3,7,9，每个数旋转要不丢失数据就要考虑如何让这个4个数都得以保留
 
image
 
前边总结了规律a[i][j] = a[n-1-j][i]，分析每组被波及的数，我们可以得出这里波及的4了数其实就是
 
a[i][j]
 
a[n-1-j][i]
 
a[n-1-i][n-1-j]
 
a[n-1-(n-1-j)][n-1-i]=a[j][n-1-i]
 
所以这里需要引入一个临时变量temp就可以解决这4个数的顺时针交换，如：
 
int temp = matrix[i][j];
matrix[i][j] = matrix[n-1-j][i];
matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
matrix[j][n-1-i] = temp;
把焦点放在一个元素上，数交换的问题解决了，
 
那么现在我们把焦点回到整个二维数组上来，每个数的旋转会波及4个数，相当于用上面的方法，每旋转一个数，就把一组的4个数都旋转了，
 
所以现在的问题就是如何才能完整的把所有的数都旋转90度且不会多旋转，继续分析吧，
 
n=1时，不需旋转。
 
n=2时，
 
image
 
只需要完成1（a[0][0]）的旋转，就完成了整个数组的旋转。
 
n=3时，
 
image
 
需要完成1,2（a[0][0],a[0][1]）的旋转，就完成了整个数组的旋转
 
n=4时，
 
image
 
需要完成1,2,3,6（a[0][0至3]，a[1][1]）的旋转
 
n=5时，
 
image
 
需要完成(a[0][0至4]，a[1][1至2])
 
大致可以总结出这么一个规律：
 
对于要旋转的数a[i][j]满足，
 
i<n/2
 
且
 
i<=j<n-1-i
 
至此问题终于完美解决了。。
*/
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] tmp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                tmp[i][j] = matrix[n - 1 - j][i];//顺时针90度的转换公式
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = tmp[i][j];
            }
        }
    }
    //方法看解释
    // public void rotate(int[][] matrix) {
    //     int n = matrix.length;
    //     int limit = (n-1)/2;
    //     for(int i=0;i<= limit; i++){
    //         for(int j=i;j<n-1-i;j++){
    //             int temp = matrix[i][j];
    //             matrix[i][j] = matrix[n-1-j][i];
    //             matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
    //             matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
    //             matrix[j][n-1-i] = temp;
    //         }
    //     }
    // }
}