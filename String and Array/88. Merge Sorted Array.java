/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
*/
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int index = m + n - 1;//从后往前加，可以不用后移，也可以避免冲突
        while (index1 >= 0 && index2 >= 0) {
            if(nums1[index1] > nums2[index2]) {
                nums1[index--] = nums1[index1--];
            } else {
                nums1[index--] = nums2[index2--];
            }
        }
        while(index1 >= 0) {
            nums1[index--] = nums1[index1--];
        }
        while(index2 >= 0) {
            nums1[index--] = nums2[index2--];
        }
    }
    
    // public void merge(int[] nums1, int m, int[] nums2, int n) {
    //     int index1 = 0;
    //     int index2 = 0;
    //     ArrayList<Integer> al = new ArrayList<Integer>(m + n);
    //     while(index1 < m && index2 < n) {
    //         if(nums1[index1] < nums2[index2]) {
    //             al.add(nums1[index1]);
    //             index1++;
    //         } else {
    //             al.add(nums2[index2]);
    //             index2++;
    //         }
    //     }
    //     if(index1 == m) {
    //         for(int i = index2; i < n ; i++) {
    //             al.add(nums2[i]);
    //         }
    //     } else if(index2 == n) {
    //         for(int i = index1; i < m ; i++) {
    //             al.add(nums1[i]);
    //         }
    //     }
    //     for(int i = 0; i < m + n; i++) {
    //         nums1[i] = al.get(i);
    //     }
    // }
}