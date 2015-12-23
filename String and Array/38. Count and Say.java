/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/
public class Solution {
    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }
        StringBuilder ans = new StringBuilder("1");
        String origin = null;
        int num = 1;
        char first = ' ';
        for(int i = 0; i < n - 1; i++) {
            origin = ans.toString();
            num = 1;
            first = origin.charAt(0);
            ans = ans.delete(0, ans.length());
            for(int j = 1; j < origin.length(); j++) {
                if(origin.charAt(j) == first) {
                    num++;
                } else {
                    ans.append(num + "" + first + "");
                    first = origin.charAt(j);
                    num = 1;
                }
            }
            ans.append(num + "" + first + "");
        }
        return ans.toString();
    }
}