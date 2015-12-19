/*
Given an integer, write a function to determine if it is a power of two.
 */

public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        boolean flag = true;
        for (int i = 0; i < 32; i++) {
            int m = n & 1;
            if (m == 0) {
                n = n >>> 1;
            } else {
                if (flag == false) {
                    return false;
                } else {
                    flag = false;
                    n = n >>> 1;
                }
            }
        }
        return true;
    }
}
/*
public class Solution {  
    public boolean isPowerOfTwo(int n) {  
       return n > 0 && ((n & (n - 1)) == 0 );  //32 & 31因为不然的话最高一位还是1，最后&出来不会是0
    }  
}  */