/*
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
*/

public class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        if (s == null) return 0;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            int d = s.charAt(i) - 'A';
            result = (int) (result + Math.pow(26.0, Math.abs((i - s.length()) * 1.0 + 1.0)) * (d + 1));
        }
        return result;
    }
}