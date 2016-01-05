/*
Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
*/
//遇到+-*进行分治，注意我用了list来作为i=返回值，因为像2*3+4再处理完*之后还要处理+，所以要吧处理的结果都存起来
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        int len = input.length();
        al = compute(input, 0, len - 1);
        return al;
    }
    public ArrayList<Integer> compute(String input, int left, int right) {
        int len = right - left + 1;
        ArrayList<Integer> ansLeft;
        ArrayList<Integer> ansRight;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        String tmp = input.substring(left, right + 1);
        if(!(tmp.contains("+") || tmp.contains("-") || tmp.contains("*"))) {
            ans.add(Integer.parseInt(tmp));
        } else {
            for(int i = left; i < left + len; i++) {
                if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                    if(input.charAt(i) == '+') {
                        ansLeft = compute(input, left, i - 1);
                        ansRight = compute(input, i + 1, right);
                        for(int k = 0; k < ansLeft.size(); k++) {
                            for(int j = 0; j < ansRight.size(); j++) {
                                ans.add(ansLeft.get(k) + ansRight.get(j));
                            }
                        }
                    } else if(input.charAt(i) == '-') {
                        ansLeft = compute(input, left, i - 1);
                        ansRight = compute(input, i + 1, right);
                        for(int k = 0; k < ansLeft.size(); k++) {
                            for(int j = 0; j < ansRight.size(); j++) {
                                ans.add(ansLeft.get(k) - ansRight.get(j));
                            }
                        }
                    } else if(input.charAt(i) == '*') {
                        ansLeft = compute(input, left, i - 1);
                        ansRight = compute(input, i + 1, right);
                        for(int k = 0; k < ansLeft.size(); k++) {
                            for(int j = 0; j < ansRight.size(); j++) {
                                ans.add(ansLeft.get(k) * ansRight.get(j));
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}