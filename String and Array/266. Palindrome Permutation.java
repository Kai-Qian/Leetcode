/*
Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.

Hint:

Consider the palindromes of odd vs even length. What difference do you notice?
Count the frequency of each character.
If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
*/
//计算字符出现次数
public class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] check = new int[256];
        char[] t = s.toCharArray();
        for(char c:t) {
            check[c]++;
        }
        int flag = 0;
        for(int i = 0; i < 256; i++) {
            if(check[i] % 2 != 0) {
                if(flag != 0) {
                    return false;
                }
                flag = 1;
            }
        }
        return true;
    }
}