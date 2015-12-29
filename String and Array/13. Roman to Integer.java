/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
I-1 V-5 X-10 L-50 C-100 D-500 M-1000
IV IX
XL XC
CD CM
 */

public class Solution {
    public int romanToInt(String s) {
        int amount = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'I') {
                if ((i + 1) < s.length() && s.charAt(i + 1) == 'V') {
                    amount += 4;
                    i = i + 2;
                } else if ((i + 1) < s.length() && s.charAt(i + 1) == 'X') {
                    amount += 9;
                    i = i + 2;
                } else {
                    amount += 1;
                    i = i + 1;
                }
            } else if (s.charAt(i) == 'X') {
                if ((i + 1) < s.length() && s.charAt(i + 1) == 'L') {
                    amount += 40;
                    i = i + 2;
                } else if ((i + 1) < s.length() && s.charAt(i + 1) == 'C') {
                    amount += 90;
                    i = i + 2;
                } else {
                    amount += 10;
                    i = i + 1;
                }
            } else if (s.charAt(i) == 'C') {
                if ((i + 1) < s.length() && s.charAt(i + 1) == 'D') {
                    amount += 400;
                    i = i + 2;
                } else if ((i + 1) < s.length() && s.charAt(i + 1) == 'M') {
                    amount += 900;
                    i = i + 2;
                } else {
                    amount += 100;
                    i = i + 1;
                }
            } else if (s.charAt(i) == 'V') {
                amount += 5;
                i = i + 1;
            } else if (s.charAt(i) == 'L') {
                amount += 50;
                i = i + 1;
            } else if (s.charAt(i) == 'D') {
                amount += 500;
                i = i + 1;
            } else if (s.charAt(i) == 'M') {
                amount += 1000;
                i = i + 1;
            }
        }
        return amount;
    }
}