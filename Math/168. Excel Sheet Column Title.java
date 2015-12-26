/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
*/
public class Solution {
    public String convertToTitle(int n) {
        String[] alpha = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        StringBuilder ans = new StringBuilder();
        int a = n;
        int b = 0;
        while(a != 0) {
            
            b = a % 26;
            if(b == 0) {
                b = 26;
            }
            ans.insert(0, alpha[b - 1]);
            a = (a - 1) / 26;//10进制转26进制，但不是从0开始，每次要减一
        }
        return ans.toString();
    }
}