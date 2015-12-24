/*
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
*/
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    //二分查找
    public int firstBadVersion(int n) {
        int mid = 1 + ((n - 1) / 2);
        int left = 1;
        int right = n;
        boolean tmp1 = isBadVersion(mid);
        boolean tmp2 = isBadVersion(mid - 1);
        while(mid == 1 || (!(tmp1 && !tmp2))) {
            if(mid == 1) {
                if(isBadVersion(mid)) {
                    break;
                } else {
                    left = mid + 1;
                    mid = left + ((right - left) / 2);//不能left + right / 2，可能会overflow
                }
            } else {
                if(tmp1 && tmp2) {
                    right = mid;
                    mid = left + ((right - left) / 2);
                    if(mid == 1) {
                        continue;
                    }
                } else if((!tmp1) && (!tmp2)) {
                    left = mid + 1;
                    mid = left + ((right - left) / 2);
                    if(mid == 1) {
                        continue;
                    }
                }
            }
            tmp1 = isBadVersion(mid);
            tmp2 = isBadVersion(mid - 1);
        }
        return mid;
    }
    // //更好的代码
    // public int firstBadVersion(int n) {
    //     int low = 1;
    //     int high = n;
    //     int ver = 0;
    //     while (low < high) {//用这个来判断是不是找到了，因为要不符合这个条件，就得high=ver和low=ver+1都至少执行一遍，那个时候说明已经找到第一个bad ver了，当然如果badver在第一个则一直执行high=ver最后low==high，如果badver在最后一个则一直执行low=ver+1最后low==high
    //         ver = low + (high - low) / 2;
    //         if (isBadVersion(ver)) {
    //             high = ver;
    //         } else {
    //             low = ver + 1;
    //         }
    //     }
    //     return low;
    // }
	//给一个排好序的数组，找一个位置来插入数组中没有的数字n，最后返回的left（low）就是要插入的位置
}