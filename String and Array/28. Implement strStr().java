/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/
public class Solution {
    public int strStr(String haystack, String needle) {
        //暴力法
        if(needle.length()==0 && haystack.length()==0 || needle.length()==0 && haystack.length()!=0)
            return 0;
        if(needle.length()>haystack.length() || needle.length()!=0 && haystack.length()==0)
            return -1;
        for(int i=0;i<=haystack.length()-needle.length();i++)//最多只用比较n-m个
        {
            int m = i;
            for(int j=0;j < needle.length(); j++) {
                if(haystack.charAt(m) != needle.charAt(j)) {
                    break;
                } else {
                    if(j == needle.length() - 1) {
                        return i;
                    } else {
                        m++;
                    }
                }
            }
        }
        return -1;
        // int indx = haystack.indexOf(needle);
        // return indx;
    }
}