/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/
//用一个delta表示正向还是反向，即上图中从第一行到最后一行还是最后一行到第一行。
// public String convert(String s, int nRows) {
    //     int len = s.length();
    //     if (len == 0 || nRows <= 1) return s;
        
    //     String[] ans = new String[nRows];
    //     Arrays.fill(ans, "");
    //     int row = 0, delta = 1;
    //     for (int i = 0; i < len; i++) {
    //         ans[row] += s.charAt(i);
    //         row += delta;
    //         if (row >= nRows) {
    //             row = nRows-2;
    //             delta = -1;
    //         }
    //         if (row < 0) {
    //             row = 1;
    //             delta = 1;
    //         }
    //     }
        
    //     String ret = "";
    //     for (int i = 0; i < nRows; i++) {
    //         ret += ans[i];
    //     }
    //     return ret;
    // }
public class Solution {
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0) {
            return "";
        }
        String[] ans = new String[numRows];
        Arrays.fill(ans, "");
        int i = 0;
        int back = numRows - 2;
        while(i < s.length()) {
            for(int j = 0; j < numRows && i < s.length(); j++) {
                ans[j] += s.charAt(i++) + "";
            }
            for(int j = back; j > 0 && i < s.length(); j--) {
                ans[j] += s.charAt(i++) + "";
            }
        }
        StringBuilder ans2 = new StringBuilder();
        // String ans2 = "";
        for(int k = 0; k < numRows; k++) {
            ans2.append(ans[k]);
            // ans2 += ans[k];
        }
        return ans2.toString();
    }
}