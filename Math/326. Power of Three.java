/*
Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
*/
public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0) {
            return false;
        }
        double ans = Math.log(n) / Math.log(3);
        long t = (long)Math.pow(3.0, Math.round(ans));//用long，因为对于2147483647，round之后再pow会超int范围
        if(t == n) {
            return true;
        } else {
            return false;
        }
    }
}

//迭代
class Solution {
public:
    bool isPowerOfThree(int n) {
        if(n <= 0) return false;
        while(n > 1){
            if(n %3 != 0) return false;
             n/=3;
        }
        return true;
    }
};

//递归
class Solution {
public:
	bool isPowerOfThree(int n) {
		if (n <= 0) return false;
		if (n == 1) return true;
		return n % 3 == 0 && isPowerOfThree(n / 3);
	}
};