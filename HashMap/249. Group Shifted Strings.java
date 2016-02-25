/*
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
Return:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
Note: For the return value, each inner list's elements must follow the lexicographic order.
*/
//用(strings[i].charAt(j + 1) - strings[i].charAt(j) + 26) % 26
//同一个list中string中相邻的字符都满足这个公式
/*
["eqdf", "qcpr"]。

((‘q’ - 'e') + 26) % 26 = 12, ((‘d’ - 'q') + 26) % 26 = 13, ((‘f’ - 'd') + 26) % 26 = 2

((‘c’ - 'q') + 26) % 26 = 12, ((‘p’ - 'c') + 26) % 26 = 13, ((‘r’ - 'p') + 26) % 26 = 2

所以"eqdf"和"qcpr"是一组shifted strings。
*/
public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        ArrayList<List<String>> ans = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
        int size = strings.length;
        for(int i = 0; i < size; i++) {
            StringBuilder s = new StringBuilder();
            if(strings[i].length() == 1) {//处理只有一个字母的情况
                s.append("a");
            }
            for(int j = 0; j < strings[i].length() - 1; j++) {
                //记住这个公式，要加26
                s.append((strings[i].charAt(j + 1) - strings[i].charAt(j) + 26) % 26);//可以直接append非string的东西 
            }
            if(!hm.containsKey(s.toString())) {//注意要用toString(),不然把StringBuilder放进去查了
                ArrayList<String> al = new ArrayList<String>();
                al.add(strings[i]);
                hm.put(s.toString(), al);
            } else {
                ArrayList<String> al = hm.get(s.toString());
                al.add(strings[i]);
            }
        }
        for(ArrayList<String> tmp:hm.values()) {
            Collections.sort(tmp);
            ans.add(tmp);
        }
        return ans;
    }
}