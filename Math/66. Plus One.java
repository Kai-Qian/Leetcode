/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/
public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) {
            return new int[0];
        }
        if(digits[digits.length - 1] != 9) {
            digits[digits.length - 1] += 1;
            return digits;
        } else {
            boolean hasCarry = true;
            for(int i = digits.length - 1; i >= 0; i--) {
                if(i == 0 && digits[i] == 9) {
                    digits[i] = 0;
                    int[] newDigits = new int[digits.length + 1];
                    newDigits[0] = 1;
                    for(int j = 1; j < digits.length; j++ ) {
                        newDigits[j] = 0;
                    }
                    return newDigits;
                }
                if(digits[i] == 9 && hasCarry == true) {
                    digits[i] = 0;
                } else if(hasCarry == true) {
                    digits[i] += 1;
                    hasCarry = false;
                    return digits;
                }
            }
        }
        return null;
    }
}