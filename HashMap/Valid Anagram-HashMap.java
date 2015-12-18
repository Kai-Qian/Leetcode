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
        } else if (s.length() == 0 && t.length() == 0) {
            return true;
        } else {
            int len1 = 0;int len3 = 1;
            int len2 = 0;int len4 = 1;
            HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
            // HashMap<Character, Integer> hm2 = new HashMap<Character, Integer>();
            
            for (int i = 0; i < s.length(); i++) {
                if (!hm.containsKey(s.charAt(i))) {
                    hm.put(s.charAt(i), 1);
                } else {
                    hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
                }
                // len1 = len1 + s.charAt(i);
                // len3 = len3 * s.charAt(i);
            }
            // System.out.println(hm);
            for (int i = 0; i < t.length(); i++) {
                if (!hm.containsKey(t.charAt(i))) {
                    // System.out.println(t.charAt(i));
                    return false;
                } else {
                    if (hm.get(t.charAt(i)) == 0) {
                        // System.out.println(1);
                        hm.remove(t.charAt(i));
                    } else {
                        hm.put(t.charAt(i), hm.get(t.charAt(i)) - 1);
                        // System.out.println(2);
                        if (hm.get(t.charAt(i)) == 0) {
                            hm.remove(t.charAt(i));
                        }
                    }
                }
                // len2 = len2 + t.charAt(i);
                // len4 = len4 * t.charAt(i);
            }
            // System.out.println(hm);
            if (hm.isEmpty()) {
                return true;
            } else {
                return false;
            }
            // if (len1 == len2 && len3 == len4) {
            //     return true;
            // } else {
            //     return false;
            // }
        }
    }
}