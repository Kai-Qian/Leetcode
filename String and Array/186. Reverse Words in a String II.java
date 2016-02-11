/*
Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?
*/
/*思路就是两步走，第一步就是将整个字符串翻转。然后从头逐步扫描，将每个遇到单词再翻转过来。

[注意事项]
1）如果是Java，应该跟面试官指出String是immutable，所以需要用char array来做。
2）follow-up问题：k-step reverse。也就是在第二部翻转的时候，把k个单词看作一个长单词，进行翻转。
*/
// public class Solution {
//     public void reverseWords(char[] s) {
//         reverse(s, 0, s.length);
//         for (int i=0, j=0; j<=s.length; j++) {
//             if (j==s.length || s[j]==' ') {
//                 reverse(s, i, j);
//                 i =  j + 1;
//             }
//         }
//     }
 
//     private void reverse(char [] s, int begin, int end) {
//         for (int i=0; i<(end-begin)/2; i++) {
//             char temp = s[begin+i];
//             s[begin+i] = s[end-i-1];
//             s[end-i-1] = temp;
//         }
//     }
// }
public class Solution {
    public void reverseWords(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while(left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            right--;
            left++;
        }
        left = 0;
        right = 0;
        while(left < s.length && right < s.length) {
            if(right != s.length - 1 && s[right] != ' ') {
                right++;
            } else {
                if(right == s.length - 1) {
                    right++;
                }
                int tmpRight = right - 1;
                while(left < tmpRight) {
                    char tmp = s[left];
                    s[left] = s[tmpRight];
                    s[tmpRight] = tmp;
                    tmpRight--;
                    left++;
                }
                right = right + 1;
                left = right;
            }
        }
    }
}