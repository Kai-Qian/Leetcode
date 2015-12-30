/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/
//不用stack，用left，right来代替stack的功能，更快
//用回溯发，实际就是画个tree用dfs
public class Solution {
    public List<String> generateParenthesis(int n) {
        int count = 1;
        int left = 1;
        int right = 0;
        ArrayList<String> al = new ArrayList<String>();
        String option = "(";
        backTracking(left, right, al, option, n, count);
        return al;
        
    }
    public void backTracking(int left, int right, ArrayList<String> al, String option, int n, int count) {
        int c = count;
        if(left == n && right == n && count == n) {
            al.add(option);
            return;
        }
        if(count < n) {
            count++;
            backTracking(left + 1, right, al, option + "(", n, count);
        }
        if(right < left) {//right<left表示stack还没空
            backTracking(left, right + 1, al, option + ")", n, c);
        }
    }
}


public class Solution {
    public List<String> generateParenthesis(int n) {
        int count = 1;
        ArrayList<String> al = new ArrayList<String>();
        Stack<Character> stack = new Stack<Character>();
        String option = "(";
        stack.push('(');
        backTracking(stack, al, option, n, count);
        return al;
        
    }
    public void backTracking(Stack<Character> stack, ArrayList<String> al, String option, int n, int count) {
        int c = count;
        if(stack.isEmpty() && count == n) {
            al.add(option);
            return;
        }
        if(count < n) {
            Stack<Character> stack1 = (Stack<Character>) stack.clone();
            count++;
            stack1.push('(');
            backTracking(stack1, al, option + "(", n, count);
        }
        Stack<Character> stack2 = (Stack<Character>) stack.clone();
        if(!stack2.isEmpty()) {
            stack2.pop();
            backTracking(stack2, al, option + ")", n, c);
        }
    }
    
    // public List<String> generateParenthesis(int n) {
    //     int count = 1;
    //     ArrayList<String> al = new ArrayList<String>();
    //     Stack<Character> stack = new Stack<Character>();
    //     String option = "(";
    //     // StringBuilder option = new StringBuilder();
    //     stack.push('(');
    //     // option.append("(");
    //     backTracking(stack, al, option, n, count);
    //     return al;
        
    // }
    // public void backTracking(Stack<Character> stack, ArrayList<String> al, StringBuilder option, int n, int count) {
    //     int c = count;
    //     // System.out.println(stack1.peek());
    //     if(stack.isEmpty() && count == n) {
    //         // System.out.println(3);
    //         al.add(option.toString());
    //         return;
    //     }
    //     if(count < n) {
    //         StringBuilder tmp1 = new StringBuilder(option.toString());
    //         Stack<Character> stack1 = (Stack<Character>) stack.clone();
    //         // System.out.println(1);
    //         count++;
    //         stack1.push('(');
    //         tmp1.append("(");
    //         backTracking(stack1, al, tmp1, n, count);
    //     }
    //     Stack<Character> stack2 = (Stack<Character>) stack.clone();
    //     if(!stack2.isEmpty()) {
    //         StringBuilder tmp2 = new StringBuilder(option.toString());
    //         // System.out.println(2);
    //         stack2.pop();
    //         tmp2.append(")");
    //         backTracking(stack2, al, tmp2, n, c);
    //     }
    // }
    
    // public List<String> generateParenthesis(int n) {
    //     //(( -> (()  ((( ->  (()) (()( ; ((()
    //     //(())(  ; (()()    -->(())() ;(()())
    //     //() -> ()(
    //     //backtracking, use recursion to find all posibilities
    //     //end condition: 1. left<right return 2.right==3 && left==3 add, return
    //     //left==3 add ")"
    //     //add either "(" or ")" to current str --> next recursion
    //     List<String> ans = new ArrayList<String>();
    //     if(n==0){return ans;}
    //     String tempStr = "";
    //     addOneParenthesis(n,0,0,tempStr,ans);
    //     return ans;
    // }
    
    // public void addOneParenthesis(int n,int left, int right, String s, List<String> ans){
    //     if(left<right){return;}
    //     if(left==n && right==n){
    //         ans.add(s);
    //         return;
    //     }
    //     if(left==n){
    //         addOneParenthesis(n,left,right+1,s+")",ans);
    //         return; //need a return, otherwith it will casue the stackOverFlow error, because multiple  
    //         //addOneParenthesis(n,left,right+1,s+")",ans);
    //     }
    //     addOneParenthesis(n,left+1,right,s+"(",ans);
    //     addOneParenthesis(n,left,right+1,s+")",ans);
    // }   
}