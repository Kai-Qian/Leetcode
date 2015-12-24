/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/
public class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int len = a.length() < b.length() ? a.length() : b.length();
        int lr = a.length() < b.length() ? 1 : 2;
        StringBuilder ans = new StringBuilder();
        for(int i = 1; i <= len; i++) {
            int sum = (a.charAt(a.length() - i) - '0') + (b.charAt(b.length() - i) - '0') + carry;
            carry = sum / 2;//要先得到carry
            sum %= 2;//再计算真实的sum
            ans.insert(0, sum + "");
        }
        
        if(lr == 1) {
            if(carry == 0) {
                ans.insert(0, b.substring(0, b.length() - len));
            } else {
                int i = b.length() - len - 1;
                while(carry != 0 && i >= 0) {
                    int sum = (b.charAt(i) - '0') + carry;
                    carry = sum / 2;
                    sum  %= 2;
                    ans.insert(0, sum + "");
                    i--;
                }
                if(carry != 0) {
                    ans.insert(0, carry + "");
                } else {
                    ans.insert(0, b.substring(0, i + 1));
                }
            }
        } else {
            if(carry == 0) {
                ans.insert(0, a.substring(0, a.length() - len));
            } else {
                int i = a.length() - len - 1;
                while(carry != 0 && i >= 0) {
                    int sum = (a.charAt(i) - '0') + carry;
                    carry = sum / 2;
                    sum  %= 2;
                    ans.insert(0, sum + "");
                    i--;
                }
                if(carry != 0) {
                    ans.insert(0, carry + "");
                } else {
                    ans.insert(0, a.substring(0, i + 1));
                }
            }
        }
        return ans.toString();
    }
    // public String addBinary(String a, String b) {
    //     int i = a.length() - 1, j = b.length() - 1, carry = 0;
    //     StringBuilder sb = new StringBuilder();
    //     while(i >=0 || j >=0){
    //         int m = i >= 0 ? a.charAt(i) - '0' : 0;//短的前端补零来进行操作，方便很多
    //         int n = j >= 0 ? b.charAt(j) - '0' : 0;
    //         int sum = m + n + carry;
    //         carry = sum / 2;
    //         sb.insert(0, String.valueOf(sum % 2));
    //         i--;
    //         j--;
    //     }
    //     if(carry != 0) sb.insert(0, '1');
    //     return sb.toString();
    // }
}