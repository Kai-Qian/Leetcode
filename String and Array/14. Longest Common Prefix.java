/*
Write a function to find the longest common prefix string amongst an array of strings.
*/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            if(!strs[i].startsWith(prefix)) {
                int len = strs[i].length() < prefix.length() ? strs[i].length() : prefix.length();
                StringBuilder pre = new StringBuilder();
                for(int j = 0; j < len; j++) {
                    if(strs[i].charAt(j) == prefix.charAt(j)) {
                        pre.append(strs[i].charAt(j) + "");
                    } else {
                        prefix = pre.toString();
                        break;
                    }
                }
                prefix = pre.toString();
            }
        }
        return prefix;
    }
}