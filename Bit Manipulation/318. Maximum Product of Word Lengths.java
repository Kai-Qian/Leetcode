/*
Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.
*/
public class Solution {
    public int maxProduct(String[] words) {
        String[] tmp = words;
        // Arrays.sort(tmp, new MyComparator());
        int[] bits = new int[tmp.length];
        for(int i = 0; i < tmp.length; i++) {
            for(int j = 0; j < tmp[i].length(); j++) {
                bits[i] = bits[i] | (1 << (tmp[i].charAt(j) - 'a'));//如果某个字母出现了就在0-25对应位置上标为1，用于之后的&
            }
        }
        int max = 0;
        for(int i = 0; i < tmp.length - 1; i++) {
            for(int j = i + 1; j < tmp.length; j++) {
                if((bits[i] & bits[j]) == 0 && max < (tmp[i].length() * tmp[j].length())) {//&为0说明没有相同的字母
                    max = tmp[i].length() * tmp[j].length();
                }
            }
        }
        return max;
    }
    //本来想排序的，但貌似还是要遍历一遍比较好
    // private static class MyComparator implements Comparator<String> {
    //     public int compare(String s1, String s2) {
    //         return -Integer.valueOf(s1.length()).compareTo(Integer.valueOf(s2.length()));
    //     }
    // }
}