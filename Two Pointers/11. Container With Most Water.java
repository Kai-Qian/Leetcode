/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
*/
public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int tmpHeight = 0;
        //从左边开始，右边不断找长度大于它的，找到就结束，那个就是左边为边时的最大面积，然后一个个试
        for(int i = 0; i < len; i++) {
            left = i;
            if(height[left] < tmpHeight) {//如果中间有小的可以直接跳过，因为那个肯定不是最大的
                continue;
            }
            for(int j = len - 1; j >= i; j--) {
                if(height[j] >= height[left]) {
                    tmpHeight = height[left];
                    int area = height[left] * (j - i);
                    max = area > max ? area : max;
                    break;
                }
            }
        }
        //还要从右往左来一遍，因为可能有[9，6，3，1]这种情况
        tmpHeight = 0;
        for(int i = len - 1; i >= 0; i--) {
            right = i;
            if(height[right] < tmpHeight) {
                continue;
            }
            for(int j = 0; j <= i; j++) {
                if(height[j] >= height[right]) {
                    tmpHeight = height[right];
                    int area = height[right] * (i - j);
                    max = area > max ? area : max;
                    break;
                }
            }
        }
        return max;
    }
}