/*
Valid Anagram My Submissions Question
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.
 */


public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        } else if (s.length() != t.length()) {
            return false;
        } else {
            int len1 = 0;int len3 = 1;
            int len2 = 0;int len4 = 1;
            for (int i = 0; i < s.length(); i++) {
                len1 = len1 + s.charAt(i);
                len3 = len3 * s.charAt(i);
            }
            for (int i = 0; i < t.length(); i++) {
                len2 = len2 + t.charAt(i);
                len4 = len4 * t.charAt(i);
            }
            if (len1 == len2 && len3 == len4) {
                return true;
            } else {
                return false;
            }
        }
    }
}