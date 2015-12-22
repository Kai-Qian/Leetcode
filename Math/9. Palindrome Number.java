/*
Determine whether an integer is a palindrome. Do this without extra space.
*/
public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int t1 = 0;
        int t2 = x;
        int ans = 0;
        while(t2 != 0) {
            t1 = t2 % 10;
            t2 = (t2 - t1) / 10;
            ans = ans * 10 + t1;//用回文的对称性生成一个数字，应该和原来的一样
        }
        return (ans - x) == 0 ? true : false;
    }
}