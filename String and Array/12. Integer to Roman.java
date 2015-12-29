/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/
public class Solution {
    public String intToRoman(int num) {
        //I-1 V-5 X-10 L-50 C-100 D-500 M-1000
        //0-1;1-10;2-100;3-1000
        //下面数组中每个相当于纸币的面额，要找出最小的纸币数，这些面额是罗马数字的硬性规定
        StringBuilder ans = new StringBuilder();    
        String symbol[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};    
        int value[]=    {1000,900,500,400, 100, 90,  50, 40,  10, 9,   5,  4,   1};
        int tmp = num;
        for(int i = 0; i < symbol.length; i++ ) {
            while(tmp >= value[i]) {
                tmp = tmp - value[i];
                ans.append(symbol[i]);
            }
        }
        return ans.toString();
    }
}