/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.
*/
//一共就1，0，8和69这几种，从左右向中间扫描
public class Solution {
    public boolean isStrobogrammatic(String num) {
        int len = num.length();
        int i = 0;
        int j = len - 1;
        while(i <= j) {
            if(num.charAt(i) != num.charAt(j)) {
                if(!((num.charAt(i) == '6' && num.charAt(j) == '9') || (num.charAt(i) == '9' && num.charAt(j) == '6'))) {
                    return false;
                }
            } else if(num.charAt(i) != '1' && num.charAt(i) != '0' && num.charAt(i) != '8') {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}