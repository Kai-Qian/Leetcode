/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
*/
public class Solution {
    public boolean isPalindrome(String s) {
        //准备用two pointers，一个在head，一个在尾，也可以用stack
        char f;
        char b;
        s = s.toLowerCase();//可能有大写，先都转换成小写
        char[] str = new char[s.length()];//先转成array，方便去除标点
        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) <= 'z' && s.charAt(i) >= 'a' || s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                str[j] = s.charAt(i);
                j++;
            }
        }
        for(int i = 0; i < j / 2; i++) {
            f = str[i];
            b = str[j - 1 - i];
            if(f != b) {
                return false;
            }
        }
        return true;
    }
}