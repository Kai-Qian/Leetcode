/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].
*/
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(1);
        if((rowIndex + 1) > 1) {
            al.remove(0);
            al.add(1);
            al.add(1);
            for(int i = 2; i < rowIndex + 1; i++) {
                int len = al.size() - 1;
                al.add(1);
                for(int j = 0; j < len; j++) {
                    al.add(al.get(j) + al.get(j + 1));
                }
                al.add(1);
                for(int j = 0; j < len + 1; j++) {
                    al.remove(0);
                }
            }
        }
        return al;
    }
    
    // public List<Integer> getRow(int rowIndex) {
    //     ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
    //     ArrayList<Integer> al = new ArrayList<Integer>();
    //     al.add(1);
    //     ans.add(al);
    //     System.out.println(ans);
    //     if((rowIndex + 1) > 1) {
    //         ans.remove(0);
    //         al = new ArrayList<Integer>();
    //         al.add(1);
    //         al.add(1);
    //         ans.add(al);
    //         for(int i = 2; i < rowIndex + 1; i++) {
    //             ArrayList<Integer> al2 = (ArrayList) ans.get(0);
    //             al = new ArrayList<Integer>();
    //             al.add(1);
    //             for(int j = 0; j < al2.size() - 1; j++) {
    //                 al.add(al2.get(j) + al2.get(j + 1));
    //             }
    //             al.add(1);
    //             ans.remove(0);
    //             ans.add(al);
    //         }
    //     }
    //     return ans.get(0);
    // }
}