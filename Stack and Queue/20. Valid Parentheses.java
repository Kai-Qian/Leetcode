/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/
public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> st = new Stack<Character>();
        boolean ans = false;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            }
            if(s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if(!st.isEmpty()) {//防止"]"这样的情况
                    char tmp = st.pop();
                    if(s.charAt(i) == ')' && tmp == '(') {
                        ans = true;
                    } else if(s.charAt(i) == '}' && tmp == '{') {
                        ans = true;
                    } else if(s.charAt(i) == ']' && tmp == '[') {
                        ans = true;
                    } else {
                        ans = false;
                        break;
                    }
                } else {
                    ans = false;
                        break;
                }
            }
        }
        if(!st.isEmpty()) {//防止"["这样的情况
            ans = false;
        }
        return ans;
    }
}