/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.
*/
//用hashmap，不过要先排序
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
        ArrayList<List<String>> ans = new ArrayList<List<String>>();
        for(int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String tmp = new String(c);
            ArrayList<String> list = hm.get(tmp);//若没有key，则会返回null
            if(list == null) {
                list = new ArrayList<String>();
            }
            list.add(strs[i]);
            hm.put(tmp, list);//会替代原来的key
        }
        for(ArrayList<String> entry : hm.values()) {
            Collections.sort(entry);
            ans.add(entry);
        }
        return ans;
    }
    // public List<List<String>> groupAnagrams(String[] strs) {
    //     if(strs == null || strs.length == 0) {
    //         return new ArrayList<List<String>>();
    //     }
    //     HashMap<String, ArrayList<Integer>> hm = new HashMap<String, ArrayList<Integer>>();
    //     ArrayList<List<String>> ans = new ArrayList<List<String>>();
        
    //     for(int i = 0; i < strs.length; i++) {
    //         char[] c = strs[i].toCharArray();
    //         Arrays.sort(c);
    //         String tmp = new String(c);
    //         if(!hm.containsKey(tmp)) {
    //             ArrayList<Integer> list2 = new ArrayList<Integer>();//冗余了，看另一种方法
    //             list2.add(i);
    //             hm.put(tmp, list2);
    //         } else {
    //             ArrayList<Integer> list3 = hm.get(tmp);
    //             list3.add(i);
    //         }
    //     }
    //     for(ArrayList<Integer> entry : hm.values()) {
    //         ArrayList<String> list = new ArrayList<String>();
    //         for(int i = 0; i < entry.size(); i++) {
    //             list.add(strs[entry.get(i)]);
    //         }
    //         Collections.sort(list, new myComparator());
    //         ans.add(list);
    //     }
    //     return ans;
    // }
    
    // public class myComparator implements Comparator {
    //     public int compare(Object o1, Object o2) {
    //         return ((String)o1).compareTo((String)o2);
    //     }
    // }
}