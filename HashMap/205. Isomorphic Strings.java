/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
*/
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hs1 = new HashMap<Character, Character>();//作为dictionary来存s与t字母之间的映射
        for(int i = 0; i < s.length(); i++) {
            if(!hs1.containsKey(s.charAt(i))) {
                if(hs1.containsValue(t.charAt(i))) {//检查对应的值是否在之前已经有加到dictionary中去过，每个不同的值对应的值应该也各不相同
                    return false;
                } else {
                    hs1.put(s.charAt(i), t.charAt(i));
                }
            } else {
                if(hs1.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}