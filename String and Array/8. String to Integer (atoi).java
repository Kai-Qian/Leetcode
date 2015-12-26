/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
*/
public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) {
            return 0;
        }
        StringBuilder ans = new StringBuilder();
        // System.out.println(str);
        str = deleteSpace(str);
        // System.out.println(str);
        boolean isOne = oneSign(str);
        if(!isOne) {
            return 0;
        }
        // System.out.println(str);
        str = deleteZero(str);
        // System.out.println(str);
        // System.out.println(str);
        if(str.equals("+") || str.equals("-")) {
            return 0;
        }
        double ansLong = Double.parseDouble(str);
        if(ansLong > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if(ansLong < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) ansLong;
        }
    }
    public String deleteSpace(String a) {
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < a.length(); i++) {
            // System.out.println(a.charAt(i));
            if(a.charAt(i) != ' ') {
                if(Character.isDigit(a.charAt(i)) || (a.charAt(i) == '+' || a.charAt(i) == '-')) {
                    ans.append(a.charAt(i) + "");
                    // System.out.println(1);
                    continue;
                } else {
                    if(ans.length() == 0) {
                        ans.append(a.charAt(i) + "");
                        // System.out.println(2);
                        continue;
                    }
                }
            }
            if(ans.length() != 0 && (a.charAt(i) == ' ' || !Character.isDigit(a.charAt(i)))) {
                // System.out.println(3);
                break;
            }
        }
        return ans.toString();
    }
    public boolean oneSign(String a) {
        if(a.length() == 0) {
            return false;
        }
        if(a.length() == 1 && (a.equals("+") || a.equals("-"))) {
            return false;
        } else if(a.length() == 1 && !Character.isDigit(a.charAt(0))) {
            return false;
        } else if(a.length() == 1 && Character.isDigit(a.charAt(0))) {
            return true;
        }
        boolean isDigitAtI = Character.isDigit(a.charAt(0));
        boolean isDigitAtIPlus1 = Character.isDigit(a.charAt(1));
        if(!isDigitAtI && !isDigitAtIPlus1) {
            return false;
        } else if(isDigitAtI) {
            return true;
        } else if(a.charAt(0) != '+' && a.charAt(0) != '-') {
            return false;
        } else {
            return true;
        }
    }
    public String deleteZero(String a) {
        StringBuilder ans = new StringBuilder();
        int i = 0;
        for(i = 0; i < a.length(); i++) {
            boolean isDigitAtI = Character.isDigit(a.charAt(i));
            if(!isDigitAtI) {
                if(a.charAt(i) == '+' || a.charAt(i) == '-') {
                    ans.append(a.charAt(i) + "");
                }
                continue;
            } else {
                if(a.charAt(i) != '0') {
                    break;
                }
            }
        }
        for(int j = i; j < a.length(); j++) {
            ans.append(a.charAt(j) + "");
        }
        return ans.toString();
    }
    // public int myAtoi(String str) {
    //     if(str == null || str.length() == 0) {
    //         return 0;
    //     }
    //     // int ans = 0;
    //     StringBuilder ans = new StringBuilder();
    //     str = deleteSpace(str);
    //     // System.out.println(str);
    //     boolean isStart = true;
    //     boolean firstTime = true;
    //     for(int i = 0; i < str.length(); i++) {
    //         boolean isDigit = Character.isDigit(str.charAt(i));
    //         if((!isDigit) && isStart == true) {
    //             if( (i + 1 < str.length()) && (Character.isDigit(str.charAt(i + 1)) || str.charAt(i) == ' ')) {
    //                 continue;    
    //             } else {
    //                 // System.out.println(1);
    //                 return 0;
    //             }
    //         } else if(firstTime) {
    //             if((str.charAt(i) == '0') && i > 0 && (str.charAt(i - 1) == '+' || str.charAt(i - 1) == '-')) {//+00123
    //                 ans.append(str.charAt(i - 1) + "");
    //                 continue;
    //             } else if(str.charAt(i) == '0') {//00123
    //                 continue;
    //             } else {
    //                 firstTime = false;
    //                 isStart = false;
    //                 if(i > 0 && (str.charAt(i - 1) == '0' || str.charAt(i - 1) == ' ')) {//00123|   123
    //                 } else if(i > 0 && (str.charAt(i - 1) == '+' || str.charAt(i - 1) == '-')) {
    //                     ans.append(str.charAt(i - 1) + "");                    
    //                 } else if((i > 0 && (!(str.charAt(i - 1) == '+' || str.charAt(i - 1) == '-')) )) {
    //                     // System.out.println(2);
    //                     return 0;
    //                 }                    
    //             }
    //         }
    //         if((!isDigit) && isStart == false) {
    //             break;
    //         }
    //         if(isDigit) {
    //             ans.append(str.charAt(i) + "");
    //             // ans = ans * 10 + (str.charAt(i) - '0');
    //         }
    //     }
    //     // System.out.println(ans);
    //     if(ans.toString().equals("+") || ans.toString().equals("-")) {
    //         return 0;
    //     }
    //     double ansLong = Double.parseDouble(ans.toString());
    //     if(ansLong > Integer.MAX_VALUE) {
    //         return Integer.MAX_VALUE;
    //     } else if(ansLong < Integer.MIN_VALUE) {
    //         return Integer.MIN_VALUE;
    //     } else {
    //         return (int) ansLong;
    //     }
    //     // return ans;
    // }
    // public String deleteSpace(String a) {
    //     StringBuilder ans = new StringBuilder();
    //     for(int i = 0; i < a.length(); i++) {
    //         if(a.charAt(i) != ' ') {
    //             ans.append(a.charAt(i) + "");
    //         } else if(a.charAt(i) == ' ') {
    //             if(ans.length() != 0) {
    //                 break;
    //             }
    //         }
    //     }
    //     return ans.toString();
    // }
}