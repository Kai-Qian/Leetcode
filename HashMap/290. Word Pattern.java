/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
*/
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> hs1 = new HashMap<Character, String>();//作为dictionary来存s与t字母之间的映射
        String[] s = str.split(" ");
        if(s.length != pattern.length()) {
            return false;
        }
        for(int i = 0; i < s.length; i++) {
            if(!hs1.containsKey(pattern.charAt(i))) {
                if(hs1.containsValue(s[i])) {//检查对应的值是否在之前已经有加到dictionary中去过，每个不同的值对应的值应该也各不相同
                    return false;
                } else {
                    hs1.put(pattern.charAt(i), s[i]);
                }
            } else {
                if(!hs1.get(pattern.charAt(i)).equals(s[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}